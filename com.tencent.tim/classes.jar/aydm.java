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
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1;
import dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.2;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;
import java.util.ArrayList;

public class aydm
  extends aygy
{
  arhz a;
  public aydm.a a;
  public boolean aGz;
  private String mPath;
  
  void CA()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public int RP()
  {
    if (this.b.Ld())
    {
      if (this.b.La()) {
        return 3;
      }
      return 4;
    }
    if (this.b.La()) {
      return 1;
    }
    return 2;
  }
  
  public Bitmap U(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_Ayii.getActivity().getResources().getDisplayMetrics();
    int i = EditPicRawImage.calculateInSampleSize((BitmapFactory.Options)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = i;
    try
    {
      localObject = aqhu.d(paramString, (BitmapFactory.Options)localObject);
      if (localObject == null)
      {
        QLog.e("EditJumpToPtu", 1, "decode" + null);
        this.jdField_a_of_type_Ayii.a(0, null, 2130772067, 0);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      for (;;)
      {
        ram.e("EditJumpToPtu", "decodeoom");
        localBitmap = null;
      }
      ram.d("EditJumpToPtu", "sampleSize" + i + " w " + localBitmap.getWidth() + " h " + localBitmap.getHeight());
      i = aqhu.getExifOrientation(paramString);
      paramString = localBitmap;
      if (i != 0)
      {
        paramString = localBitmap;
        if (i % 90 == 0)
        {
          ram.d("EditJumpToPtu", "has exif rotate" + i);
          int j = localBitmap.getWidth();
          int k = localBitmap.getHeight();
          paramString = new Matrix();
          paramString.postRotate(i, j / 2.0F, k / 2.0F);
          paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, k, paramString, true);
        }
      }
      this.jdField_a_of_type_Aydm$a.obtainMessage(2, paramString).sendToTarget();
    }
    return paramString;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    if (this.aGz)
    {
      paramayqb = paramayqb.a;
      paramayqb.bsR += 1;
    }
  }
  
  public boolean aB(Context paramContext)
  {
    if (ausc.bb(paramContext, "com.tencent.ttpic")) {
      try
      {
        int i = ausc.w(paramContext, "com.tencent.ttpic");
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
  
  void dN(String paramString)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(getContext(), getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setMessage(paramString);
    this.jdField_a_of_type_Arhz.setCancelable(false);
    this.jdField_a_of_type_Arhz.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.b.changeState(0);
    Activity localActivity;
    if (paramInt1 == 100)
    {
      if (paramInt2 != -1) {
        break label183;
      }
      localActivity = this.b.b().getActivity();
      if (localActivity != null) {}
    }
    else
    {
      return;
    }
    ((axpr)axov.a(5)).a[RP()].cW(localActivity);
    if (this.b.bQ != null) {
      this.b.bQ.clear();
    }
    for (;;)
    {
      try
      {
        paramIntent = ((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")).toString();
        ram.d("EditJumpToPtu", "onActivityResult PI_TU, new path " + paramIntent);
        if (!TextUtils.isEmpty(paramIntent)) {
          ThreadManager.excute(new EditJumpToPtu.2(this, paramIntent), 64, null, true);
        }
        if (this.mPath == null) {
          break;
        }
        dx.deleteFile(new File(this.mPath));
        this.mPath = null;
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        continue;
      }
      label183:
      ram.d("EditJumpToPtu", "onActivityResult cancel ");
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Aydm$a = new aydm.a();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ras.bw("0X80080E2", ras.bpo);
    if (aB(this.jdField_a_of_type_Ayii.getContext()))
    {
      ThreadManager.post(new EditJumpToPtu.1(this), 5, null, true);
      dN(acfp.m(2131705412));
      return;
    }
    ras.bw("0X80080E4", ras.bpo);
    paramObject = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://tu.qq.com/websites/guide/sticker.html");
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_editor");
    localIntent.setComponent(paramObject);
    this.jdField_a_of_type_Ayii.getActivity().startActivityForResult(localIntent, 101);
  }
  
  public boolean um(String paramString)
  {
    DoodleLayout localDoodleLayout = this.b.a.a();
    if (localDoodleLayout != null)
    {
      Bitmap localBitmap3 = localDoodleLayout.a(0, false);
      Bitmap localBitmap2 = this.b.W();
      if (localBitmap2 == null) {
        return false;
      }
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap3 != null)
      {
        localBitmap1 = rop.d(localBitmap2, localBitmap3);
        localDoodleLayout.s(localBitmap3);
      }
      return rop.d(localBitmap1, paramString);
    }
    return false;
  }
  
  public class a
    extends Handler
  {
    public a() {}
    
    public void dispatchMessage(Message paramMessage)
    {
      super.dispatchMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        if (aydm.a(aydm.this) != null)
        {
          ras.bw("0X80080E3", ras.bpo);
          paramMessage = new ArrayList();
          paramMessage.add(Uri.parse(aydm.a(aydm.this)));
          paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
          paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
          aydm.this.a.getActivity().startActivityForResult(paramMessage, 100);
        }
        aydm.this.CA();
        return;
      case 2: 
        paramMessage = (Bitmap)paramMessage.obj;
        aydm.this.b.e(paramMessage, false);
        if (aydm.this.b.b != null)
        {
          aydm.this.b.b.bsz();
          aydm.this.b.btf();
        }
        aydm.this.aGz = true;
        return;
      }
      aydm.this.b.changeState(0);
      aydm.this.CA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydm
 * JD-Core Version:    0.7.0.1
 */