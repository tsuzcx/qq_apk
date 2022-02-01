import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.widget.AdapterView;
import java.io.File;

public class akbp
  extends sxi
{
  private boolean NW;
  protected akbo a;
  public akbp.a a;
  protected akbt a;
  protected PicBrowserActivity b;
  protected boolean crn;
  
  public akbp(PicBrowserActivity paramPicBrowserActivity, sxm paramsxm)
  {
    super(paramPicBrowserActivity, paramsxm);
    this.b = paramPicBrowserActivity;
    this.jdField_a_of_type_Akbt = ((akbt)paramsxm);
    paramPicBrowserActivity = this.b.getIntent();
    if (paramPicBrowserActivity != null) {
      this.crn = paramPicBrowserActivity.getBooleanExtra("is_forbid_action_sheet", false);
    }
  }
  
  private void Ni(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.b, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.b.startActivityForResult(localIntent, 1001);
  }
  
  public void MG(boolean paramBoolean)
  {
    this.crn = paramBoolean;
  }
  
  protected void RK(int paramInt)
  {
    if ((this.crn) || (this.b.isFinishing())) {}
    for (;;)
    {
      return;
      Object localObject3 = "";
      Object localObject4 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject3;
      if (this.jdField_a_of_type_Akbt.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_Akbt.a(paramInt).a != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_Akbt.a(paramInt).a.localPath)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_Akbt.a(paramInt).a.localPath;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_Akbt.a(paramInt).a.localPath); localObject1 != null; localObject1 = aoiz.getFile(this.jdField_a_of_type_Akbt.a(paramInt).a.bSZ))
      {
        localObject3 = ausj.b(this.b);
        ((ausj)localObject3).addButton(acfp.m(2131709628));
        ((ausj)localObject3).addButton("发送给QQ好友");
        ((ausj)localObject3).addCancelButton(acfp.m(2131709629));
        ((ausj)localObject3).a(new akbq(this, (ausj)localObject3, (File)localObject1, (String)localObject2));
        ((ausj)localObject3).show();
        return;
        label182:
        localObject2 = aoiz.getFilePath(this.jdField_a_of_type_Akbt.a(paramInt).a.bSZ);
      }
    }
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_Akbo == null) {
      this.jdField_a_of_type_Akbo = new akbo(paramContext);
    }
    return this.jdField_a_of_type_Akbo;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    RK(paramInt);
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean arG()
  {
    return this.crn;
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561479, null);
  }
  
  public void dAx()
  {
    int i = -1;
    int k;
    akbr localakbr1;
    akbr localakbr2;
    if (this.jdField_a_of_type_Akbt != null)
    {
      j = this.jdField_a_of_type_Akbt.getSelectedIndex();
      k = this.jdField_a_of_type_Akbt.getCount();
      if (k == 1)
      {
        localakbr1 = this.jdField_a_of_type_Akbt.b(j);
        j = i;
        localakbr2 = localakbr1;
        if (this.jdField_a_of_type_Akbo != null)
        {
          this.jdField_a_of_type_Akbo.notifyDataSetChanged();
          localakbr2 = localakbr1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_Akbp$a != null) {
        this.jdField_a_of_type_Akbp$a.a(localakbr2, j);
      }
      return;
      if (j == k - 1)
      {
        localakbr1 = this.jdField_a_of_type_Akbt.b(j);
        i = j - 1;
        this.jdField_a_of_type_Akbt.setSelectedIndex(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localakbr1 = this.jdField_a_of_type_Akbt.b(j);
        this.jdField_a_of_type_Akbt.setSelectedIndex(j);
        i = j;
        break;
      }
      localakbr1 = null;
      break;
      localakbr2 = null;
    }
  }
  
  public void initData()
  {
    akbr localakbr = this.jdField_a_of_type_Akbt.a();
    if (localakbr != null)
    {
      localakbr.thubmRect = ((Rect)this.b.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localakbr.isImgCenterCropMode = this.b.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1001)) {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onExitAnimationEnd()
  {
    super.onExitAnimationEnd();
    this.b.dAw();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      RK(this.jdField_a_of_type_Akbt.getSelectedIndex());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Akbt instanceof akbt))
    {
      this.jdField_a_of_type_Akbt.onPause();
      this.NW = true;
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if (((this.jdField_a_of_type_Akbt instanceof akbt)) && (this.NW) && (this.jdField_a_of_type_Akbo != null)) {
      this.jdField_a_of_type_Akbo.notifyDataSetChanged();
    }
    this.NW = false;
    super.onResume();
  }
  
  public static abstract interface a
  {
    public abstract void a(akbr paramakbr, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbp
 * JD-Core Version:    0.7.0.1
 */