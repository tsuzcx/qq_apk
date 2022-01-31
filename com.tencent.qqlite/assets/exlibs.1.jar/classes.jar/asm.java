import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.io.File;

public class asm
  extends DownloadIconsListener
{
  public asm(Leba paramLeba) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.a.a.getCount();
    int i = 0;
    boolean bool1;
    for (boolean bool2 = false; i < j; bool2 = bool1)
    {
      Object localObject = (LebaViewItem)this.a.a.getItem(i);
      bool1 = bool2;
      if (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
      {
        bool1 = bool2;
        if (paramString.equals(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName))
        {
          ((LebaViewItem)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramBitmap);
          bool2 = true;
          localObject = LebaUtil.a(this.a.a(), paramString, ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (paramBitmap != null)
            {
              bool1 = bool2;
              if (BaseApplicationImpl.a != null)
              {
                localObject = "LebaIcon://" + ((File)localObject).getAbsolutePath();
                bool1 = bool2;
                if (BaseApplicationImpl.a.get(localObject) == null)
                {
                  BaseApplicationImpl.a.put(localObject, paramBitmap);
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
      i += 1;
    }
    this.a.b(new asn(this, paramString, paramBitmap, bool2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asm
 * JD-Core Version:    0.7.0.1
 */