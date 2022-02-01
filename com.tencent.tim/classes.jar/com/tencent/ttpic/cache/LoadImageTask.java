package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadImageTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public LoadImageTask(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    this.cache = paramMap;
    this.resourceList = paramList;
    if (this.resourceList == null) {
      this.resourceList = new ArrayList();
    }
    this.dataPath = paramString1;
    this.materialId = paramString2;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    if (this.cache == null) {
      return Boolean.valueOf(false);
    }
    paramVarArgs = null;
    Iterator localIterator = this.resourceList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isCancelled()) {
        return Boolean.valueOf(false);
      }
      Object localObject = this.dataPath + File.separator + str;
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, this.sampleSize);
      if (TextUtils.isEmpty(this.materialId))
      {
        label108:
        if (!BitmapUtils.isLegal((Bitmap)localObject)) {
          break label163;
        }
        this.cache.put(str, localObject);
        paramVarArgs = (Void[])localObject;
      }
      for (;;)
      {
        break;
        str = this.materialId + File.separator + str;
        break label108;
        label163:
        if (BitmapUtils.isLegal(paramVarArgs)) {
          this.cache.put(str, paramVarArgs);
        }
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask
 * JD-Core Version:    0.7.0.1
 */