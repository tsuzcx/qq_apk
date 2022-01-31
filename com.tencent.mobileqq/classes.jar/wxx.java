import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1;
import com.tencent.biz.qqstory.takevideo.EditJumpToPtu.2;
import com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wxx
  extends xal
{
  bety jdField_a_of_type_Bety;
  private String jdField_a_of_type_JavaLangString;
  public wxy a;
  public boolean a;
  
  public wxx(@NonNull xan paramxan)
  {
    super(paramxan);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Wxy = new wxy(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_Xan.a(0);
    if ((paramInt1 != 100) || (paramInt2 == -1)) {}
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        wxe.b("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.post(new EditJumpToPtu.2(this, paramIntent), 5, null, true);
        }
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          ey.a(new File(this.jdField_a_of_type_JavaLangString));
          this.jdField_a_of_type_JavaLangString = null;
        }
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      wxe.b("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wxk.b("0X80080E2", wxk.a);
    if (a(this.jdField_a_of_type_Xby.a()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      b(alud.a(2131704031));
      return;
    }
    wxk.b("0X80080E4", wxk.a);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "http://tu.qq.com/websites/guide/sticker.html");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_Xby.getActivity().startActivityForResult(localIntent, 101);
  }
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramxlb = paramxlb.a;
      paramxlb.a += 1;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Xby.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.a((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = bdhj.a(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_Xby.a(0, null, 2130772028, 0);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        wxe.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      wxe.b("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = bdhj.b(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null) {
            this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.b = i;
          }
          wxe.b("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_Wxy.obtainMessage(2, paramString).sendToTarget();
    }
  }
  
  public boolean a(Context paramContext)
  {
    if (bhtl.a(paramContext, "com.tencent.ttpic")) {
      try
      {
        int i = bhtl.a(paramContext, "com.tencent.ttpic");
        if (i >= 490) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_Xan.jdField_a_of_type_Wzb.a();
    Bitmap localBitmap3 = localDoodleLayout.b(0);
    Bitmap localBitmap2 = this.jdField_a_of_type_Xan.a();
    boolean bool1;
    if (localBitmap2 == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        Bitmap localBitmap1 = localBitmap2;
        if (localBitmap3 != null) {
          localBitmap1 = xqw.c(localBitmap2, localBitmap3);
        }
        bool2 = xqw.a(localBitmap1, paramString);
        bool1 = bool2;
      } while (localDoodleLayout == null);
      bool1 = bool2;
    } while (localBitmap3 == null);
    localDoodleLayout.a(localBitmap3);
    return bool2;
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(a(), a().getDimensionPixelSize(2131298914));
    }
    this.jdField_a_of_type_Bety.a(paramString);
    this.jdField_a_of_type_Bety.setCancelable(false);
    this.jdField_a_of_type_Bety.show();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */