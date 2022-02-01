package com.tencent.biz.qqstory.album.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pkd.a;
import pkz;
import ram;

public class PhotoSelecter
{
  public static String TAG = "Q.qqstory.recommendAlbum.logic.PhotoSelecter";
  
  static class SelectPhotoTask
    implements Runnable
  {
    PhotoSelecter.a a;
    Context context;
    int count;
    List<a> mb;
    long zY;
    long zZ;
    
    public void run()
    {
      Collections.sort(this.mb);
      Object localObject2 = new ArrayList();
      int j = this.mb.size() / this.count;
      Object localObject1 = null;
      int i = 0;
      while (i < this.mb.size())
      {
        if (i % j == 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
        }
        ((ArrayList)localObject1).add(this.mb.get(i));
        i += 1;
      }
      int[] arrayOfInt = new int[((ArrayList)localObject2).size()];
      i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      j = 0;
      ArrayList localArrayList = new ArrayList();
      i = 1;
      int k;
      if (localArrayList.size() < this.count)
      {
        int m = 0;
        k = 0;
        while (k < arrayOfInt.length)
        {
          m += arrayOfInt[k];
          k += 1;
        }
        if (m < arrayOfInt.length) {}
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((a)((Iterator)localObject2).next()).a);
        }
      }
      Object localObject3;
      if (j >= ((ArrayList)localObject2).size())
      {
        localObject1 = PhotoSelecter.TAG;
        localObject3 = new StringBuilder().append("round = ");
        k = i + 1;
        ram.d((String)localObject1, i);
        j = 0;
        i = k;
      }
      for (;;)
      {
        localObject3 = ((ArrayList)((ArrayList)localObject2).get(j)).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (a)((Iterator)localObject3).next();
        } while (((a)localObject1).state != 1);
        for (;;)
        {
          if (localObject1 == null)
          {
            arrayOfInt[j] = 1;
            Log.d("stevcao", "abandon cursor = " + j);
            j += 1;
            break;
          }
          if (localArrayList.size() == 0)
          {
            ((a)localObject1).state = 2;
            localArrayList.add(localObject1);
            label410:
            j += 1;
            break;
          }
          localObject3 = localArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Bitmap localBitmap1 = ((a)((Iterator)localObject3).next()).getBitmap(this.context);
            Bitmap localBitmap2 = ((a)localObject1).getBitmap(this.context);
            long l1 = System.currentTimeMillis();
            double d = pkz.a(localBitmap1, localBitmap2);
            long l2 = this.zY;
            this.zY = (System.currentTimeMillis() - l1 + l2);
            this.zZ += 1L;
            if (d >= 0.7D) {
              ((a)localObject1).state = 3;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0)
            {
              j += 1;
              break;
            }
            ((a)localObject1).state = 2;
            localArrayList.add(localObject1);
            break label410;
            ram.d(PhotoSelecter.TAG, "compare total time = " + this.zY + " compareTimes = " + this.zZ);
            ram.d(PhotoSelecter.TAG, "single compare time = " + this.zY / this.zZ);
            this.a.ch((ArrayList)localObject1);
            return;
          }
          localObject1 = null;
        }
      }
    }
    
    class a
      implements Comparable<a>
    {
      pkd.a a;
      Bitmap co;
      int state;
      
      public int a(@NonNull a parama)
      {
        return (int)(this.a.mCreateTime - parama.a.mCreateTime);
      }
      
      public Bitmap getBitmap(Context paramContext)
      {
        BitmapFactory.Options localOptions;
        if (this.co == null) {
          localOptions = new BitmapFactory.Options();
        }
        try
        {
          this.co = this.a.a(paramContext, 1, localOptions);
          this.co = pkz.v(this.co);
          return this.co;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ram.e(PhotoSelecter.TAG, "get thumbnail failed!", paramContext);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ch(ArrayList<pkd.a> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSelecter
 * JD-Core Version:    0.7.0.1
 */