import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.Iterator;
import java.util.List;

public class fqt
  extends AsyncTask
{
  public fqt(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(FileCategoryUtil.e(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    FMLocalFileActivity.b(this.a);
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if (localFileCategoryEntity.G == 4)
      {
        localFileCategoryEntity.F = paramInteger.intValue();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    FMLocalFileActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fqt
 * JD-Core Version:    0.7.0.1
 */