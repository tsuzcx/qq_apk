import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.2;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class ayft
  extends aygy
  implements ayfv
{
  private List<String> Nv;
  public String cWT;
  private String cpM;
  private int eKb;
  private String[] jq = { "default", "local_slides", "local_singlePhoto", "local_singleVideo", "bigVshare" };
  private View mContainerView;
  private EditText mEditText;
  
  public ayft(@NonNull aygz paramaygz, int paramInt)
  {
    super(paramaygz);
    this.eKb = paramInt;
    if (this.eKb < this.jq.length) {}
    for (this.cWT = this.jq[this.eKb];; this.cWT = this.jq[0])
    {
      pre.a().a("EditVideoDTextFace.mSrcFrom", this.cWT);
      return;
    }
  }
  
  private void afi(int paramInt)
  {
    if ((paramInt != 44) && (paramInt != 41) && (paramInt != 9) && (paramInt != 42) && (paramInt != 34) && (paramInt != 22)) {
      eRu();
    }
  }
  
  private void b(DoodleLayout paramDoodleLayout)
  {
    int j = 100;
    int i = j;
    if (paramDoodleLayout != null)
    {
      i = j;
      if (paramDoodleLayout.a() != null)
      {
        i = j;
        if (paramDoodleLayout.a().mItems != null) {
          i = Math.min(paramDoodleLayout.a().tp(), paramDoodleLayout.a().mItems.size());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoDTextFace", 2, " check Last text layer count is " + i);
    }
    if (i <= 0) {
      eRv();
    }
  }
  
  private void eRw()
  {
    Object localObject = (aydg)a(aydg.class);
    if (localObject == null) {
      throw new IllegalStateException("not support doodle.");
    }
    localObject = ((aydg)localObject).a();
    DynamicTextItem localDynamicTextItem = ((DoodleLayout)localObject).a().a(((DoodleLayout)localObject).getFrom());
    ((DoodleLayout)localObject).a(((DoodleLayout)localObject).a().a(), false);
    if (localDynamicTextItem != null)
    {
      ((DoodleLayout)localObject).a(localDynamicTextItem, 0, 0, true);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131700432), 0).show();
    ThreadManager.getUIHandler().post(new EditVideoDTextFace.2(this, (DoodleLayout)localObject));
  }
  
  private boolean oz(int paramInt)
  {
    return (paramInt != 5) && (paramInt != 9) && (paramInt != 34) && (paramInt != 42) && (paramInt != 22) && (paramInt != 41);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    paramayqb = ((aydg)a(aydg.class)).a().a();
    int i = paramayqb.mItems.size();
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < i)
    {
      localStringBuilder.append(((ayjw.c)paramayqb.mItems.get(paramInt)).c.getType() + 1);
      if (paramInt < i - 1) {
        localStringBuilder.append(",");
      }
      paramInt += 1;
    }
    rar.a("video_edit_text", "pub_withText", 0, 0, new String[] { this.cWT, localStringBuilder.toString(), String.valueOf(i), "" });
  }
  
  public void a(DoodleLayout paramDoodleLayout)
  {
    b(paramDoodleLayout);
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoDTextFace", 2, "editVideoStateChanged" + paramInt1 + "->" + paramInt2);
    }
    if ((paramInt1 == 0) || ((paramInt2 != 0) && (paramInt1 == 44)) || ((paramInt2 == 40) && (paramInt1 == 41))) {
      afi(paramInt2);
    }
    label78:
    do
    {
      ayjw localayjw;
      do
      {
        do
        {
          do
          {
            break label78;
            break label78;
            do
            {
              return;
            } while ((paramInt2 != 0) || (!oz(paramInt1)));
            paramObject = (aydg)a(aydg.class);
          } while (paramObject == null);
          paramObject = paramObject.a();
        } while (paramObject == null);
        localayjw = paramObject.a();
      } while (localayjw == null);
      paramInt1 = 0;
      if (localayjw.mItems != null) {
        paramInt1 = paramObject.a().mItems.size();
      }
    } while (paramInt1 != 0);
    eRv();
  }
  
  public void eRu()
  {
    if ((this.mContainerView != null) && (this.mContainerView.getVisibility() == 0)) {
      this.mContainerView.setVisibility(8);
    }
  }
  
  public void eRv()
  {
    if ((this.mContainerView != null) && (this.mContainerView.getVisibility() == 8))
    {
      this.mContainerView.setVisibility(0);
      rar.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.cWT, "", "", "" });
      if (this.mEditText != null) {
        this.mEditText.setSelection(0);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    a(ayfv.class, this);
    DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)axov.a(7);
    this.cpM = localDynamicTextConfigManager.gV(this.eKb);
    this.Nv = axug.at(0);
    if (TextUtils.isEmpty(this.cpM)) {
      this.cpM = acfp.m(2131705599);
    }
    axug.ab(0, Collections.singletonList(this.cpM));
    this.b.b().getRootView().postDelayed(new EditVideoDTextFace.1(this, localDynamicTextConfigManager), 1000L);
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.a.getActivity().getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
        localInputMethodManager.hideSoftInputFromWindow(this.a.getRootView().getWindowToken(), 0);
      }
    }
    super.onDestroy();
    axug.ab(0, this.Nv);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayft
 * JD-Core Version:    0.7.0.1
 */