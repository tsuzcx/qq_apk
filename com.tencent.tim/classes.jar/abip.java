import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.CmShowRscCacheManager.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;

public class abip
{
  private static abip a;
  private final SparseArray<abip.a> bU = new SparseArray();
  
  private abip()
  {
    cCh();
  }
  
  public static abip a()
  {
    try
    {
      if (a == null) {
        a = new abip();
      }
      abip localabip = a;
      return localabip;
    }
    finally {}
  }
  
  private void cCi()
  {
    Object localObject1 = new abis.a();
    ((abis.a)localObject1).cpg = 100;
    ((abis.a)localObject1).mItemId = 1L;
    ((abis.a)localObject1).mName = "all_room3D";
    localObject1 = ((abis.a)localObject1).qX() + "all_room3D.json";
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      try
      {
        localObject2 = new JSONObject(aqhq.readFileToString((File)localObject2)).optJSONObject("data");
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("downloadUrl");
          localObject2 = ((JSONObject)localObject2).optJSONObject("list");
          Iterator localIterator = ((JSONObject)localObject2).keys();
          while (localIterator.hasNext())
          {
            Object localObject3 = (String)localIterator.next();
            int i = ApolloUtil.ck((String)localObject3);
            if (i > -2147483648)
            {
              localObject3 = ((JSONObject)localObject2).optJSONObject((String)localObject3);
              if (localObject3 != null)
              {
                localObject3 = ((JSONObject)localObject3).optString("source_qq");
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  abip.a locala = new abip.a();
                  locala.bgt = "all_room3D.json";
                  locala.bgs = ((String)localObject1);
                  locala.mId = i;
                  locala.mResType = 8;
                  locala.bgr = ((String)localObject3);
                  this.bU.put(i, locala);
                }
              }
            }
          }
        }
        ApolloUtil.Da("小窝json不存在");
      }
      catch (Exception localException)
      {
        QLog.e("rscContent_CmShowRscCacheManager", 1, "initRoomJson e:", localException);
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscCacheManager", 2, "initRoomJson mRoomRscMap:" + this.bU);
        }
        return;
      }
    }
    QLog.e("rscContent_CmShowRscCacheManager", 1, "initRoomJson file is no exsit path:" + localException);
  }
  
  public abip.a a(int paramInt1, int paramInt2)
  {
    abip.a locala = null;
    if (paramInt1 == 8) {
      locala = (abip.a)this.bU.get(paramInt2);
    }
    if (locala == null) {
      ApolloUtil.Da("未获取资源getRscItem type:" + paramInt1 + " id:" + paramInt2);
    }
    return locala;
  }
  
  public void cCh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscCacheManager", 2, "onRoomZipUpdated");
    }
    this.bU.clear();
    ThreadManager.executeOnSubThread(new CmShowRscCacheManager.1(this));
  }
  
  public static class a
  {
    public String bgr;
    public String bgs;
    public String bgt;
    public int mId;
    public int mResType;
    
    public boolean Yp()
    {
      if ((ApolloUtil.jN(qU())) && (this.mResType == 8)) {
        return ApolloUtil.jN(abxi.bit + this.mId + File.separator + "room.bin");
      }
      return false;
    }
    
    public String getDownloadUrl()
    {
      if (this.mResType == 6) {
        return this.bgr;
      }
      if ((!TextUtils.isEmpty(this.bgs)) && (!TextUtils.isEmpty(this.bgr)))
      {
        if (this.bgs.endsWith("/")) {
          return this.bgs + this.mId + "/" + this.bgr;
        }
        return this.bgs + "/" + this.mId + "/" + this.bgr;
      }
      return "";
    }
    
    public boolean isResourceReady()
    {
      return (new File(qU()).exists()) && (Yp());
    }
    
    public String qU()
    {
      if (8 == this.mResType) {
        return abxi.bit + this.mId + File.separator + this.bgr;
      }
      return abxi.bim + this.mId + File.separator + this.bgr;
    }
    
    public String qV()
    {
      if (QLog.isColorLevel()) {
        QLog.d("IdolRscItem", 2, "getFaceDataJson this:" + this);
      }
      if (this.mResType == 6)
      {
        Object localObject1 = arwv.toMD5(this.bgr);
        localObject1 = new File(abxi.biv + (String)localObject1 + File.separator + "face.json");
        if (((File)localObject1).exists()) {
          try
          {
            localObject1 = aqhq.readFileToString((File)localObject1);
            return localObject1;
          }
          catch (Exception localException1)
          {
            QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException1);
          }
        }
      }
      for (;;)
      {
        return "";
        Object localObject2 = new File(abxi.bir + this.mId + File.separator + "blendshape.json");
        if (((File)localObject2).exists())
        {
          try
          {
            localObject2 = aqhq.readFileToString((File)localObject2);
            return localObject2;
          }
          catch (Exception localException2)
          {
            QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException2);
          }
          continue;
          Object localObject3 = new File(abxi.bir + this.mId + File.separator + "face.json");
          if (((File)localObject3).exists())
          {
            try
            {
              localObject3 = aqhq.readFileToString((File)localObject3);
              return localObject3;
            }
            catch (Exception localException3)
            {
              QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException3);
            }
          }
          else
          {
            Object localObject4 = new File(abxi.bir + this.mId + File.separator + "blendshape.json");
            if (((File)localObject4).exists()) {
              try
              {
                localObject4 = aqhq.readFileToString((File)localObject4);
                return localObject4;
              }
              catch (Exception localException4)
              {
                QLog.e("IdolRscItem", 1, "getFaceDataJson " + localException4);
              }
            }
          }
        }
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("IdolRscItem{");
      localStringBuffer.append("mResType=").append(this.mResType);
      localStringBuffer.append(", mDownFileName='").append(this.bgr).append('\'');
      localStringBuffer.append(", mId=").append(this.mId);
      localStringBuffer.append(", mDownPrefixxUrl='").append(this.bgs).append('\'');
      localStringBuffer.append(", mCacheJsonName='").append(this.bgt).append('\'');
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abip
 * JD-Core Version:    0.7.0.1
 */