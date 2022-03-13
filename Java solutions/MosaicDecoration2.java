package CSacademy;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class MosaicDecoration2 {
    /*
    * W --> wall width
    * H --> wall height
    * A --> width of mosaic tile (columns)
    * B --> height of mosaic tile (rows)
    *
    * 1 pile has 10 tiles and costs M$  --> tile size is AxB inches
    * Cutting mosaic tile costs C$ per inch
    *
    * input  --> W H A B M C
    * output --> price
    */
    public static void main(String[] args) {
        long W = 8;
        long H = 5;
        long A = 3;
        long B = 2;
        long M = 100;
        long C = 3;
        System.out.println(mosaicDecoration2(W, H, A, B, M, C));
    }

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
