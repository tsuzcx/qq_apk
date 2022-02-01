import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobSegment;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class ayfe
  extends aygy
  implements View.OnClickListener, ayff.a, ayfg
{
  public static final String cWS = plr.atc;
  private ayff a;
  private RelativeLayout oi;
  private ViewStub y;
  
  public ayfe(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void eRe()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), ForwardFriendListActivity.class);
    localIntent.putExtra("extra_choose_friend", 4);
    localIntent.putExtra("extra_left_btn_text", acfp.m(2131705681));
    a().getActivity().startActivityForResult(localIntent, 2);
    a().getActivity().overridePendingTransition(2130772009, 2130771989);
  }
  
  private void rp(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ram.w("Q.qqstory.publish.edit.EditVideoAt", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ram.w("Q.qqstory.publish.edit.EditVideoAt", "create folder : " + bool);
    }
  }
  
  public JobSegment<ayqb, ayqb> a(int paramInt)
  {
    return new ayqa(this.a, null, this.a.ha(paramInt));
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    paramInt = this.a.lW(paramInt);
    if (paramInt > 0) {
      rar.a("video_edit", "send_alt", 0, 0, new String[] { paramInt + "" });
    }
  }
  
  @NonNull
  public List<String> au(int paramInt)
  {
    if (paramInt < 0) {
      return Collections.EMPTY_LIST;
    }
    return this.a.au(paramInt);
  }
  
  protected boolean e(Message paramMessage)
  {
    if (paramMessage.what == 6)
    {
      int i = paramMessage.arg2;
      this.a.afe(i);
      return true;
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    a().getActivity();
    if (paramInt2 != -1)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAt", "the resultCode of choosing a qq single friend is not RESULT_OK!");
      this.b.changeState(0);
      return;
    }
    if (paramIntent == null)
    {
      ram.e("Q.qqstory.publish.edit.EditVideoAt", "the intent of choosing a single qq friend is null!");
      this.b.changeState(0);
      return;
    }
    String str2 = paramIntent.getStringExtra("extra_choose_friend_uin");
    String str1 = paramIntent.getStringExtra("extra_choose_friend_name");
    Object localObject = paramIntent.getStringExtra("extraChooseFriendRemark");
    if (str2 == null) {
      ram.i("Q.qqstory.publish.edit.EditVideoAt", "choose a single qq friend. result null");
    }
    for (;;)
    {
      this.b.changeState(0);
      return;
      ram.b("Q.qqstory.publish.edit.EditVideoAt", "choose a single qq friend. uin = %s name = %s remark = %s.", str2, str1, localObject);
      rar.a("video_edit", "list_alt", 0, 0, new String[0]);
      paramIntent = (Intent)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoAt", "remark is null. set remark to name.");
        paramIntent = str1;
      }
      localObject = str1;
      if (TextUtils.equals(str2, str1))
      {
        ram.w("Q.qqstory.publish.edit.EditVideoAt", "remark is null(choose a friend by searching.). set name to remark.");
        localObject = paramIntent;
      }
      this.a.bJ(str2, paramIntent, (String)localObject);
    }
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate()
  {
    super.onCreate();
    this.y = ((ViewStub)y(2131363026));
    if (this.oi == null) {
      this.oi = ((RelativeLayout)this.y.inflate());
    }
    if (this.a == null) {
      this.a = new ayff(getContext(), this.oi);
    }
    this.a.a(this);
    rp(cWS);
    a(ayfg.class, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestory();
    }
  }
  
  public void onStateChanged(int paramInt)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoAt", "EditVideoAt onStateChanged state = %d.", Integer.valueOf(paramInt));
    this.b.changeState(paramInt);
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if (this.oi.getVisibility() != 0) {
        this.oi.setVisibility(0);
      }
      return;
    case 18: 
      eRe();
      return;
    }
    this.oi.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfe
 * JD-Core Version:    0.7.0.1
 */