import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoMagicStickUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class enc
  extends AsyncTask
{
  private enc(PhotoListActivity paramPhotoListActivity) {}
  
  protected List a(Object... paramVarArgs)
  {
    int k = 0;
    paramVarArgs = PhotoMagicStickUtils.a(this.a, PhotoListActivity.a(this.a), PhotoListActivity.b(this.a), PhotoListActivity.b(this.a));
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
    long l2 = AlbumUtil.jdField_b_of_type_Long;
    if (AlbumUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(PhotoListActivity.a(this.a)))
    {
      i = ((Integer)AlbumUtil.jdField_a_of_type_JavaUtilHashMap.get(PhotoListActivity.a(this.a))).intValue();
      j = k;
    }
    for (;;)
    {
      if (j < paramVarArgs.size())
      {
        LocalPhotoInfo localLocalPhotoInfo = (LocalPhotoInfo)paramVarArgs.get(j);
        if (localLocalPhotoInfo.jdField_a_of_type_JavaLangString == null) {}
        for (;;)
        {
          j += 1;
          break;
          if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(localLocalPhotoInfo.jdField_a_of_type_JavaLangString))
          {
            localLocalPhotoInfo.e = 1;
          }
          else if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.c) && (PhotoListActivity.c(this.a) != null) && (localLocalPhotoInfo.jdField_a_of_type_JavaLangString.equals(PhotoListActivity.c(this.a))))
          {
            localLocalPhotoInfo.e = 1;
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localLocalPhotoInfo.jdField_a_of_type_JavaLangString);
          }
          else if ((PhotoListActivity.c(this.a)) && (l1 - l2 <= 60000L) && (i == paramVarArgs.size()) && (localLocalPhotoInfo.jdField_a_of_type_JavaLangString.equals(AlbumUtil.jdField_a_of_type_JavaLangString)))
          {
            localLocalPhotoInfo.e = 3;
          }
          else
          {
            localLocalPhotoInfo.e = 2;
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
    Object localObject = null;
    if (PhotoListActivity.d(this.a))
    {
      localObject = new LocalPhotoInfo();
      ((LocalPhotoInfo)localObject).jdField_a_of_type_JavaLangString = "file://camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Ena.a(paramList);
    if (PhotoListActivity.d(this.a)) {
      paramList.remove(localObject);
    }
    int i;
    int j;
    if (PhotoListActivity.e(this.a))
    {
      PhotoListActivity.b(this.a, false);
      i = PhotoListActivity.a();
      if (i != -1) {
        break label270;
      }
      localObject = (LinkedHashMap)AlbumUtil.jdField_b_of_type_JavaUtilHashMap.get(PhotoListActivity.a(this.a));
      if (localObject == null) {
        break label307;
      }
      j = ((LinkedHashMap)localObject).size();
      if (j <= 0) {
        break label307;
      }
      i = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
    }
    label270:
    label307:
    for (;;)
    {
      if ((i == -1) && (PhotoListActivity.c(this.a)))
      {
        paramList = paramList.iterator();
        j = 0;
        if (paramList.hasNext()) {
          if (((LocalPhotoInfo)paramList.next()).e == 3) {
            i = j;
          }
        }
      }
      for (;;)
      {
        label216:
        j = this.a.jdField_a_of_type_Ena.getCount();
        if (j == 0) {
          j = k;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_Ena.notifyDataSetChanged();
          PhotoListActivity.a(this.a);
          return;
          j += 1;
          break;
          PhotoListActivity.a(-1);
          break label216;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     enc
 * JD-Core Version:    0.7.0.1
 */