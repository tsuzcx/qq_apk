import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class enh
  implements View.OnClickListener
{
  public enh(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c.setClickable(false);
    if (this.a.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false))
    {
      paramView = PhotoPreviewActivity.a(this.a).iterator();
      for (long l = 0L; paramView.hasNext(); l += FileUtils.a((String)paramView.next())) {}
      if (l > 5242880L) {}
      for (int i = 1; (FileManagerUtil.a()) && (i != 0); i = 0)
      {
        FMDialogUtil.a(this.a, 2131558759, 2131558756, new eni(this));
        return;
      }
      PhotoPreviewActivity.b(this.a);
      return;
    }
    PhotoPreviewActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     enh
 * JD-Core Version:    0.7.0.1
 */