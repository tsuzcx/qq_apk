import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class cjc
  extends AsyncTask
{
  private cjc(PhotoListActivity paramPhotoListActivity) {}
  
  protected List a(Object... paramVarArgs)
  {
    int k = 0;
    LogTag.a();
    paramVarArgs = AlbumUtil.c(this.a, PhotoListActivity.a(this.a), PhotoListActivity.b(this.a), MediaFileFilter.filterOfOrdinal(PhotoListActivity.a(this.a)));
    LogTag.a("PEAK", "getAlbumMedias");
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    int i;
    int j;
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
      for (i = 0; i < this.a.jdField_a_of_type_JavaUtilArrayList.size(); i = j + 1)
      {
        j = i;
        if (!new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).exists())
        {
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
          j = i - 1;
        }
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = AlbumUtil.c;
    if (AlbumUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(PhotoListActivity.a(this.a)))
    {
      i = ((Integer)AlbumUtil.jdField_a_of_type_JavaUtilHashMap.get(PhotoListActivity.a(this.a))).intValue();
      j = k;
    }
    for (;;)
    {
      if (j < paramVarArgs.size())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramVarArgs.get(j);
        if (localLocalMediaInfo.jdField_a_of_type_JavaLangString == null) {}
        for (;;)
        {
          j += 1;
          break;
          if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(localLocalMediaInfo.jdField_a_of_type_JavaLangString))
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 1;
          }
          else if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.c) && (PhotoListActivity.c(this.a) != null) && (localLocalMediaInfo.jdField_a_of_type_JavaLangString.equals(PhotoListActivity.c(this.a))))
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 1;
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
          }
          else if ((PhotoListActivity.b(this.a)) && (l1 - l2 <= 60000L) && (i == paramVarArgs.size()) && (localLocalMediaInfo.jdField_a_of_type_JavaLangString.equals(AlbumUtil.jdField_a_of_type_JavaLangString)))
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 3;
          }
          else
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 2;
          }
        }
      }
      return paramVarArgs;
      i = 0;
      j = k;
    }
  }
  
  protected void a(List paramList)
  {
    int k = 0;
    PhotoListActivity.c(this.a);
    if (paramList == null)
    {
      this.a.jdField_a_of_type_Cja.a(paramList);
      this.a.jdField_a_of_type_Cja.notifyDataSetChanged();
      PhotoListActivity.a(this.a);
      return;
    }
    Object localObject = null;
    if (PhotoListActivity.c(this.a))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).jdField_b_of_type_JavaLangString = "mobileqq/preview";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Cja.a(paramList);
    if (PhotoListActivity.c(this.a)) {
      paramList.remove(localObject);
    }
    int i;
    int j;
    if (PhotoListActivity.d(this.a))
    {
      PhotoListActivity.b(this.a, false);
      i = PhotoListActivity.a();
      if (i != -1) {
        break label303;
      }
      localObject = (LinkedHashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
      if (localObject == null) {
        break label340;
      }
      j = ((LinkedHashMap)localObject).size();
      if (j <= 0) {
        break label340;
      }
      i = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
    }
    label303:
    label340:
    for (;;)
    {
      if ((i == -1) && (PhotoListActivity.b(this.a)))
      {
        paramList = paramList.iterator();
        j = 0;
        if (paramList.hasNext()) {
          if (((LocalMediaInfo)paramList.next()).jdField_b_of_type_Int == 3) {
            i = j;
          }
        }
      }
      for (;;)
      {
        label249:
        j = this.a.jdField_a_of_type_Cja.getCount();
        if (j == 0) {
          j = k;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_Cja.notifyDataSetChanged();
          PhotoListActivity.a(this.a);
          return;
          j += 1;
          break;
          PhotoListActivity.a(-1);
          break label249;
          if (i > j - 1)
          {
            j -= 1;
          }
          else
          {
            j = k;
            if (i >= 0) {
              j = i;
            }
          }
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    PhotoListActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjc
 * JD-Core Version:    0.7.0.1
 */