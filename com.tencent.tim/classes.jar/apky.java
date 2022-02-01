import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.2;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class apky
  extends aplp<apky.b, apkm>
{
  private apkm a;
  private aqnt.a jdField_b_of_type_Aqnt$a = new apkz(this);
  private aqnt jdField_b_of_type_Aqnt;
  boolean cRh = false;
  private Context mContext;
  private boolean mIsPlaying;
  private LayoutInflater mLayoutInflater;
  private BroadcastReceiver mReceiver = new apla(this);
  
  public apky(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    paramXMediaEditor = new IntentFilter();
    paramXMediaEditor.addAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    paramXMediaEditor.addAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    if (!this.cRh)
    {
      this.mContext.registerReceiver(this.mReceiver, paramXMediaEditor);
      this.cRh = true;
    }
  }
  
  private void b(apkm paramapkm)
  {
    if (this.mIsPlaying) {}
    apky.b localb;
    do
    {
      return;
      this.mIsPlaying = true;
      this.jdField_a_of_type_Apkm = paramapkm;
      paramapkm.mIsPlaying = true;
      this.jdField_b_of_type_Aqnt = new aqnt(paramapkm.mPath, new Handler());
      this.jdField_b_of_type_Aqnt.cf(this.mContext);
      this.jdField_b_of_type_Aqnt.aFk();
      this.jdField_b_of_type_Aqnt.a(this.jdField_b_of_type_Aqnt$a);
      this.jdField_b_of_type_Aqnt.start();
      localb = (apky.b)this.e.findViewHolderForAdapterPosition(paramapkm.mPosition);
    } while (localb == null);
    if (paramapkm.mIsPlaying)
    {
      paramapkm = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772338);
      localb.mIcon.setImageDrawable(paramapkm);
      paramapkm.start();
      return;
    }
    localb.mIcon.setImageResource(2130847905);
  }
  
  private void g(apkm paramapkm)
  {
    awjs.c localc = new awjs.c(qem.getQQAppInterface(), paramapkm.mPath, paramapkm.mTroopUin);
    localc.a(new apky.a(paramapkm));
    paramapkm.mUploadStatus = 1;
    ThreadManager.post(new AudioItem.2(this, localc), 8, null, true);
  }
  
  public apky.b a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new apky.b(this.mLayoutInflater.inflate(2131561742, paramViewGroup, false));
    b(paramViewGroup.ji, paramViewGroup);
    b(paramViewGroup.mN, paramViewGroup);
    b(paramViewGroup.mItemView, paramViewGroup);
    if (this.e.Ls() != 0)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      localLayoutParams.leftMargin = this.e.Ls();
      localLayoutParams.rightMargin = this.e.Ls();
    }
    return paramViewGroup;
  }
  
  public void a(View paramView, apky.b paramb)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((apkm)paramb.a).mPath)) && (TextUtils.isEmpty(((apkm)paramb.a).mUrl)));
      a((apkm)paramb.a);
      return;
      g((apkm)paramb.a);
      paramb.cM.setVisibility(4);
      paramb.mIcon.setVisibility(4);
      paramb.mN.setVisibility(4);
      return;
      this.jdField_a_of_type_Aplb$a.h(paramb);
    } while ((this.jdField_a_of_type_Apkm == null) || (!this.jdField_a_of_type_Apkm.mIsPlaying) || (this.jdField_a_of_type_Apkm.mPosition != ((apkm)paramb.a).mPosition));
    c(this.jdField_a_of_type_Apkm);
  }
  
  public void a(apkm paramapkm)
  {
    if (this.mIsPlaying)
    {
      if (paramapkm.mIsPlaying)
      {
        c(paramapkm);
        return;
      }
      c(this.jdField_a_of_type_Apkm);
      d(paramapkm);
      return;
    }
    d(paramapkm);
  }
  
  public void a(apky.b paramb, apkm paramapkm, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramb.mIcon.setVisibility(0);
      paramb.ji.setVisibility(4);
      paramb.mN.setVisibility(4);
    }
    for (;;)
    {
      paramb.cM.setText(paramapkm.mTime + "\"");
      if (!paramapkm.mIsPlaying) {
        break;
      }
      paramapkm = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772338);
      paramb.mIcon.setImageDrawable(paramapkm);
      paramapkm.start();
      return;
      paramb.ji.setVisibility(0);
      switch (paramapkm.mUploadStatus)
      {
      default: 
        break;
      case 0: 
        paramb.cM.setVisibility(4);
        paramb.mIcon.setVisibility(4);
        paramb.mN.setVisibility(4);
        break;
      case 1: 
        paramb.cM.setVisibility(4);
        paramb.mIcon.setVisibility(4);
        paramb.mN.setVisibility(4);
        break;
      case 2: 
        paramb.cM.setVisibility(4);
        paramb.mIcon.setVisibility(4);
        paramb.mN.setVisibility(0);
        break;
      case 3: 
        paramb.cM.setVisibility(0);
        paramb.mIcon.setVisibility(0);
        paramb.mN.setVisibility(4);
      }
    }
    paramb.mIcon.setImageResource(2130847905);
  }
  
  public void c(apkm paramapkm)
  {
    apky.b localb;
    if ((paramapkm != null) && (paramapkm.mIsPlaying))
    {
      this.mIsPlaying = false;
      this.jdField_b_of_type_Aqnt.release();
      this.jdField_b_of_type_Aqnt = null;
      paramapkm.mIsPlaying = false;
      this.jdField_a_of_type_Apkm = null;
      localb = (apky.b)this.e.findViewHolderForAdapterPosition(paramapkm.mPosition);
      if (localb != null)
      {
        if (!paramapkm.mIsPlaying) {
          break label93;
        }
        paramapkm = (AnimationDrawable)this.mContext.getResources().getDrawable(2130772338);
        localb.mIcon.setImageDrawable(paramapkm);
        paramapkm.start();
      }
    }
    return;
    label93:
    localb.mIcon.setImageResource(2130847905);
  }
  
  public void d(apkm paramapkm)
  {
    if ((!TextUtils.isEmpty(paramapkm.mPath)) && (new File(paramapkm.mPath).exists())) {
      b(paramapkm);
    }
    while (TextUtils.isEmpty(paramapkm.mUrl)) {
      return;
    }
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, this.mContext.getString(2131695432), 0).show();
      return;
    }
    ThreadManager.post(new AudioItem.1(this, paramapkm), 8, null, true);
  }
  
  public void e(apkm paramapkm)
  {
    f(paramapkm);
  }
  
  public void f(apkm paramapkm)
  {
    if ((!TextUtils.isEmpty(paramapkm.mUrl)) || (paramapkm.mUploadStatus != 0)) {
      return;
    }
    g(paramapkm);
  }
  
  public void h(apkm paramapkm)
  {
    if ((TextUtils.isEmpty(paramapkm.mUrl)) && (paramapkm.mUploadStatus == 1)) {
      g(paramapkm);
    }
  }
  
  public void release()
  {
    if (this.mIsPlaying) {
      c(this.jdField_a_of_type_Apkm);
    }
    if (this.cRh)
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.cRh = false;
    }
  }
  
  public class a
    implements awjs.b
  {
    public apkm c;
    
    public a(apkm paramapkm)
    {
      this.c = paramapkm;
    }
    
    public void onComplete(String paramString)
    {
      this.c.mUploadStatus = 3;
      this.c.setUrl(paramString);
      ((Activity)apky.a(apky.this)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
    }
    
    public void onError(int paramInt)
    {
      this.c.mUploadStatus = 2;
      ((Activity)apky.a(apky.this)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
    }
    
    public void onProgress(int paramInt) {}
  }
  
  public static class b
    extends aplc.a<apkm>
  {
    public TextView cM;
    public ImageView ji;
    public ImageView mIcon;
    public View mItemView;
    public ImageView mN;
    
    public b(View paramView)
    {
      super();
      this.mItemView = paramView;
      this.mIcon = ((ImageView)paramView.findViewById(2131363086));
      this.mN = ((ImageView)paramView.findViewById(2131377227));
      this.ji = ((ImageView)paramView.findViewById(2131364694));
      this.cM = ((TextView)paramView.findViewById(2131363093));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apky
 * JD-Core Version:    0.7.0.1
 */