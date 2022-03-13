package CSacademy;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class MosaicDecoration2 {
    public static long mosaicDecoration2(long ww, long wh, long tw, long th, long pp, long cp){
        long tilesPerRow, tilesPerColumn, ttlTilesCost, cutCost = 0;
        tilesPerRow = (long)Math.ceil((double)ww/tw); //calculating tiles needed in a row (cut tiles inclusive)
        tilesPerColumn = (long)Math.ceil((double)wh/th); // calculating tiles needed in a column (cut tiles inclusive)
        ttlTilesCost = (long)Math.ceil((double)(tilesPerRow * tilesPerColumn)/10) * pp; //tiles total cost based on piles amount

        if(Math.floorDiv(ww,tw) != (double)ww/tw){
            cutCost += wh;
            System.out.println(cutCost);
        }
        if(Math.floorDiv(wh, th) != (double)wh/th)
            cutCost += ww;

        cutCost *= cp;
        return ttlTilesCost + cutCost;
    }
}
