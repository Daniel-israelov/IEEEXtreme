package CSacademy;

import java.math.BigInteger;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class CraftingWoodenTables {
    public static BigInteger tables3(long woodsForTable, long slotsInPocket, long maxAmountInSlot, long totalWoods){
        BigInteger numOfCraftedTables, slotsWithWood, remainingWoods;
        BigInteger lft = BigInteger.ZERO;
        BigInteger rgt = new BigInteger(String.valueOf(Math.floorDiv(totalWoods, woodsForTable)));
        BigInteger pocketSlots = new BigInteger(String.valueOf(slotsInPocket));
        BigInteger ttlWoods = new BigInteger(String.valueOf(totalWoods));
        BigInteger maxSpaceInSlot = new BigInteger(String.valueOf(maxAmountInSlot));
        /*
        * Using a simple binary search.
        * lft is initialized to point to the head of the 'pocket' (array index 0).
        * lft is also the total amount of tables.
        * rgt is initialized to point to the end of the pocket
        * rgt might be initialized to a number larger than the pocket-size, but it doesn't affect the solution.
        * If rgt is initialized to 0 it means that the required amount of woods to craft a single table is larger
        * than the actual amount of woods we have.
        * The 'numOfCraftedTables' represents the 'mid' of binary search algo and stores the amount of
        * tables crafted.
        * */
        while(!lft.equals(rgt)){
            numOfCraftedTables = new BigInteger(String.valueOf(lft
                    .add(rgt)
                    .add(BigInteger.ONE)))
                    .divide(BigInteger.TWO); //mid

            slotsWithWood = new BigInteger(String.valueOf(pocketSlots
                    .subtract(numOfCraftedTables))); //amount of slots with woods in them (NOT including tables)

            remainingWoods = ttlWoods.subtract(numOfCraftedTables
                    .multiply(BigInteger.valueOf(woodsForTable))); // the amount of remaining woods after crafting X tables

            if((maxSpaceInSlot.multiply(slotsWithWood)).compareTo(remainingWoods) >= 0)
                lft = numOfCraftedTables;
            else
                rgt = numOfCraftedTables.subtract(BigInteger.ONE);
        }
        return lft;
    }
}
