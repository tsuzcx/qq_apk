import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class uif
{
  private Context a = QQStoryContext.a().a().getBaseContext();
  
  private boolean a(uja paramuja)
  {
    if ((paramuja.jdField_a_of_type_Int <= 240) || (paramuja.jdField_b_of_type_Int <= 240))
    {
      wxe.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramuja.jdField_a_of_type_Int), Integer.valueOf(paramuja.jdField_b_of_type_Int), paramuja.jdField_a_of_type_JavaLangString);
      return false;
    }
    if (paramuja.jdField_b_of_type_Int / paramuja.jdField_a_of_type_Int <= 0.2F)
    {
      wxe.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramuja.jdField_a_of_type_Int), Integer.valueOf(paramuja.jdField_b_of_type_Int), paramuja.jdField_a_of_type_JavaLangString);
      return false;
    }
    if (paramuja.jdField_b_of_type_Int / paramuja.jdField_a_of_type_Int >= 2.2F)
    {
      wxe.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramuja.jdField_a_of_type_Int), Integer.valueOf(paramuja.jdField_b_of_type_Int), paramuja.jdField_a_of_type_JavaLangString);
      return false;
    }
    return true;
  }
  
  public List<uja> a(Context paramContext, long paramLong, boolean paramBoolean, int paramInt)
  {
    wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore : " + paramLong);
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
        localObject3 = QQStoryContext.a().a().createEntityManager();
        Object localObject4 = "date_modified >=" + paramLong + " and ";
        str = "_size<=12582912 and (_data like '%" + (String)localObject1 + "%' or " + "_data" + alud.a(2131713913);
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
            paramContext = paramContext.query((Uri)localObject4, new String[] { "_id", "_data", "date_added", "date_modified", "latitude", "longitude", "_size", "width", "height", "orientation", "mime_type" }, (String)localObject1, null, str);
          }
          catch (Exception paramContext)
          {
            wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "query cursor error:" + paramContext);
            paramContext = null;
            continue;
            wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore DB result = " + paramContext.getCount());
            if (paramContext.getCount() != 0) {
              continue;
            }
            paramContext.close();
            return localArrayList;
            try
            {
              ((awgf)localObject3).a().a();
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
              localObject1 = new uja();
              ((uja)localObject1).jdField_a_of_type_Long = paramContext.getInt(paramInt);
              ((uja)localObject1).jdField_b_of_type_Long = paramContext.getLong(i);
              ((uja)localObject1).jdField_a_of_type_Double = paramContext.getDouble(j);
              ((uja)localObject1).jdField_b_of_type_Double = paramContext.getDouble(k);
              ((uja)localObject1).jdField_b_of_type_Int = paramContext.getInt(n);
              ((uja)localObject1).jdField_a_of_type_Int = paramContext.getInt(i1);
              ((uja)localObject1).jdField_c_of_type_Int = paramContext.getInt(i2);
              ((uja)localObject1).jdField_a_of_type_JavaLangString = paramContext.getString(i3);
              ((uja)localObject1).e = paramContext.getLong(m);
              ((uja)localObject1).jdField_b_of_type_JavaLangString = "";
              ((uja)localObject1).jdField_d_of_type_JavaLangString = paramContext.getString(i4);
              ((uja)localObject1).jdField_c_of_type_Long = paramContext.getLong(i5);
              ((uja)localObject1).jdField_d_of_type_Long = ((uja)localObject1).jdField_b_of_type_Long;
              if (arso.b(((uja)localObject1).jdField_a_of_type_JavaLangString)) {
                continue;
              }
              if (paramContext.moveToNext()) {
                continue;
              }
              ((awgf)localObject3).a().c();
            }
            catch (Exception localException)
            {
              wxe.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "write to db error:" + localException);
              paramContext.close();
              ((awgf)localObject3).a().b();
              continue;
            }
            finally
            {
              paramContext.close();
              ((awgf)localObject3).a().b();
            }
            wxe.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "queryFromMediaStore match result = " + localArrayList.size());
            return localArrayList;
            if (!a((uja)localObject1)) {
              continue;
            }
            ((awgf)localObject3).b(((uja)localObject1).a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uif
 * JD-Core Version:    0.7.0.1
 */