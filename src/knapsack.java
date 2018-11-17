//programmed by: Stephen Batcheldor
//created on: 17/11/2018
//desc: should run a dynamic programming algorithm from a test question

import java.util.*;

public class knapsack
{
    public static void main(String [] args)
    {
        knapsack k = new knapsack();

        Obj[] object = {
                new Obj(2, 5),
                new Obj(3, 8),
                new Obj(1, 7),
                new Obj(2, 15)
        };
        int W = 5;

        System.out.print(k.run(object, W));
    }

    public static int run(Obj [] object, int W)
    {
        int [][] V = new int[object.length][W];

        for(int i = 0; i < V.length; i++)
        {
            V[i] = new int[W];
        }

        for(int i = 1; i < W; i++)
            V[0][i] = 0;

        for(int i = 1; i < object.length; i++)
        {
            for(int j = 0; j < W; j++)
            {
                if(j >= object[i].getW())
                    V[i][j] = MAX(V[i-1][j], V[i-1][j-object[i].getW()] + object[i].getV());
                else
                    V[i][j] = V[i-1][j];
            }
        }
        return V[object.length - 1][W - 1];
    }

    public static int MAX(int i, int j)
    {
        if(i < j)
            return j;
        else return i;
    }

}


