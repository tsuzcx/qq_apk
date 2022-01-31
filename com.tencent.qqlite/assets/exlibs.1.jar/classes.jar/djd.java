import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class djd
  extends FMObserver
{
  public djd(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.b(false);
  }
  
  protected void a(String paramString, boolean paramBoolean, int paramInt1, long paramLong, List paramList, int paramInt2)
  {
    QfileCloudFileTabView.a(this.a, paramBoolean);
    this.a.g = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (FileManagerUtil.a(localWeiYunFileInfo.jdField_b_of_type_JavaLangString) == 0)
      {
        String str = QfileCloudFileTabView.a(this.a).a().a(localWeiYunFileInfo.a, localWeiYunFileInfo.jdField_b_of_type_JavaLangString, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.g = str;
        }
      }
    }
    if (!paramString.equals(this.a.jdField_b_of_type_JavaLangString)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.a)) {
      this.a.a.clear();
    }
    this.a.a.addAll(paramList);
    if (!this.a.jdField_b_of_type_JavaLangString.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    this.a.jdField_b_of_type_Long = paramLong;
    this.a.d = true;
    this.a.g();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     djd
 * JD-Core Version:    0.7.0.1
 */