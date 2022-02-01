import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class jxj
{
  private static jxj jdField_a_of_type_Jxj;
  private static final Object aD = new Object();
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener = new jxk(this);
  private URLDrawable d;
  private ArrayList<String> jx = new ArrayList();
  private ArrayList<String> jy = new ArrayList();
  
  public static jxj a()
  {
    if (jdField_a_of_type_Jxj == null) {
      jdField_a_of_type_Jxj = new jxj();
    }
    return jdField_a_of_type_Jxj;
  }
  
  private void aAU()
  {
    synchronized (aD)
    {
      if ((this.d == null) && (this.jx != null) && (this.jx.size() > 0))
      {
        String str = (String)this.jx.get(0);
        this.d = aoop.getDrawable(str);
        this.d.setDownloadListener(this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener);
        this.d.downloadImediatly();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "startImageDownload url:" + str);
        }
      }
      return;
    }
  }
  
  public void bM(ArrayList<String> paramArrayList)
  {
    synchronized (aD)
    {
      if ((this.jx == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label118;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (!this.jx.contains(str)))
        {
          this.jx.add(str);
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementCoverPreloadManager", 2, "addImagesToPreload url:" + str);
          }
        }
      }
    }
    aAU();
    label118:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxj
 * JD-Core Version:    0.7.0.1
 */