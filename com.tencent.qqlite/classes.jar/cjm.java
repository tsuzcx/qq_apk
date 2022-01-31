import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class cjm
  implements View.OnClickListener
{
  public cjm(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    this.a.b.setClickable(false);
    paramView = this.a.getIntent();
    Object localObject;
    int i;
    if (paramView.getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      localObject = PhotoPreviewActivity.a(this.a).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l += FileUtils.a((String)((Iterator)localObject).next())) {}
      if (l > 5242880L)
      {
        i = 1;
        if ((!FileManagerUtil.a()) || (i == 0)) {
          break label149;
        }
        FMDialogUtil.a(this.a, 2131362018, 2131362016, new cjn(this));
      }
    }
    for (;;)
    {
      localObject = paramView.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      i = j;
      if (localObject != null) {
        i = ((ArrayList)localObject).size();
      }
      StatisticConstants.a(paramView, i);
      return;
      i = 0;
      break;
      label149:
      PhotoPreviewActivity.b(this.a);
      continue;
      PhotoPreviewActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjm
 * JD-Core Version:    0.7.0.1
 */