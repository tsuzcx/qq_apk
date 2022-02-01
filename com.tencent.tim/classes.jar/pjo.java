import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class pjo
{
  private Context mContext = QQStoryContext.a().getApplication().getBaseContext();
  
  private boolean a(pkd.a parama)
  {
    if ((parama.width <= 240) || (parama.height <= 240))
    {
      ram.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(parama.width), Integer.valueOf(parama.height), parama.mPath);
      return false;
    }
    if (parama.height / parama.width <= 0.2F)
    {
      ram.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(parama.width), Integer.valueOf(parama.height), parama.mPath);
      return false;
    }
    if (parama.height / parama.width >= 2.2F)
    {
      ram.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(parama.width), Integer.valueOf(parama.height), parama.mPath);
      return false;
    }
    return true;
  }
  
  public List<pkd.a> a(Context paramContext, long paramLong, boolean paramBoolean, int paramInt)
  {
    ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore : " + paramLong);
    Object localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    String str = "/DCIM/";
    Object localObject3 = ((File)localObject1).listFiles();
    localObject1 = str;
    int j;
    int i;
    if (localObject3 != null)
    {
      j = localObject3.length;
      i = 0;
    }
    for (;;)
    {
      localObject1 = str;
      ArrayList localArrayList;
      if (i < j)
      {
        localObject1 = localObject3[i];
        if (TextUtils.equals(((File)localObject1).getName().toLowerCase(), "camera")) {
          localObject1 = "/DCIM/" + ((File)localObject1).getName() + "/";
        }
      }
      else
      {
        localArrayList = new ArrayList();
        localObject3 = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
        Object localObject4 = "date_modified >=" + paramLong + " and ";
        str = "_size<=12582912 and (_data like '%" + (String)localObject1 + "%' or " + "_data" + acfp.m(2131714008);
        localObject1 = str;
        if (paramLong > 0L) {
          localObject1 = (String)localObject4 + str;
        }
        if (paramBoolean) {}
        for (;;)
        {
          try
          {
            str = " asc limit " + paramInt;
            paramContext = paramContext.getContentResolver();
            localObject4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            str = "date_modified" + str;
            paramContext = alld.query(paramContext, (Uri)localObject4, new String[] { "_id", "_data", "date_added", "date_modified", "latitude", "longitude", "_size", "width", "height", "orientation", "mime_type" }, (String)localObject1, null, str);
          }
          catch (Exception paramContext)
          {
            ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "query cursor error:" + paramContext);
            paramContext = null;
            continue;
            ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore DB result = " + paramContext.getCount());
            if (paramContext.getCount() != 0) {
              continue;
            }
            paramContext.close();
            return localArrayList;
            try
            {
              ((EntityManager)localObject3).getTransaction().begin();
              paramContext.moveToFirst();
              paramInt = paramContext.getColumnIndex("_id");
              i = paramContext.getColumnIndex("date_modified");
              j = paramContext.getColumnIndex("latitude");
              int k = paramContext.getColumnIndex("longitude");
              int m = paramContext.getColumnIndex("_size");
              int n = paramContext.getColumnIndex("height");
              int i1 = paramContext.getColumnIndex("width");
              int i2 = paramContext.getColumnIndex("orientation");
              int i3 = paramContext.getColumnIndex("_data");
              int i4 = paramContext.getColumnIndex("mime_type");
              int i5 = paramContext.getColumnIndex("date_added");
              localObject1 = new pkd.a();
              ((pkd.a)localObject1).mId = paramContext.getInt(paramInt);
              ((pkd.a)localObject1).mCreateTime = paramContext.getLong(i);
              ((pkd.a)localObject1).bg = paramContext.getDouble(j);
              ((pkd.a)localObject1).bh = paramContext.getDouble(k);
              ((pkd.a)localObject1).height = paramContext.getInt(n);
              ((pkd.a)localObject1).width = paramContext.getInt(i1);
              ((pkd.a)localObject1).orientation = paramContext.getInt(i2);
              ((pkd.a)localObject1).mPath = paramContext.getString(i3);
              ((pkd.a)localObject1).size = paramContext.getLong(m);
              ((pkd.a)localObject1).bN = "";
              ((pkd.a)localObject1).mime = paramContext.getString(i4);
              ((pkd.a)localObject1).mAddTime = paramContext.getLong(i5);
              ((pkd.a)localObject1).zV = ((pkd.a)localObject1).mCreateTime;
              if (ahbj.fileExistsAndNotEmpty(((pkd.a)localObject1).mPath)) {
                continue;
              }
              if (paramContext.moveToNext()) {
                continue;
              }
              ((EntityManager)localObject3).getTransaction().commit();
            }
            catch (Exception localException)
            {
              ram.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "write to db error:" + localException);
              paramContext.close();
              ((EntityManager)localObject3).getTransaction().end();
              continue;
            }
            finally
            {
              paramContext.close();
              ((EntityManager)localObject3).getTransaction().end();
            }
            ram.w("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore match result = " + localArrayList.size());
            return localArrayList;
            if (!a((pkd.a)localObject1)) {
              continue;
            }
            ((EntityManager)localObject3).persistOrReplace(((pkd.a)localObject1).a());
            localArrayList.add(localObject1);
            continue;
            if (paramContext != null) {
              continue;
            }
            return localArrayList;
          }
          str = " desc limit " + paramInt;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjo
 * JD-Core Version:    0.7.0.1
 */