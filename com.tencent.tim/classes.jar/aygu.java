import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;
import java.util.HashMap;
import java.util.Map;

public class aygu
  extends aygy
  implements DialogInterface.OnDismissListener, ayph.a
{
  ayph jdField_a_of_type_Ayph;
  LinkerSummaryView jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView;
  private boolean dzg;
  RelativeLayout oj;
  public Map<String, aypi> qR = new HashMap();
  
  public aygu(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public static void r(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    String str = "1";
    if ((paramContext instanceof QIMCameraCaptureActivity)) {
      str = "1";
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_story", "", "video_edit", paramString, 0, 0, str, "", "", "");
      return;
      if ((paramContext instanceof EditVideoActivity)) {
        str = "2";
      } else if ((paramContext instanceof EditPicActivity)) {
        str = "2";
      }
    }
  }
  
  public void Zn(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ayph == null)
    {
      this.jdField_a_of_type_Ayph = new ayph(getContext());
      this.jdField_a_of_type_Ayph.a(this);
    }
    Object localObject = a();
    if ((localObject != null) && (((aypi)localObject).mUrl != null)) {}
    for (localObject = ((aypi)localObject).mUrl;; localObject = null)
    {
      this.jdField_a_of_type_Ayph.show((String)localObject);
      if ((!paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)) {
        anot.a(null, "dc00899", "grp_story", "", "video_edit", "clk_linkbutton", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  public aypi a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.a;
    }
    return null;
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    String str = null;
    super.a(paramInt, paramayqb);
    aypi localaypi = a();
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (localaypi != null)
    {
      bool = localaypi.jQ();
      localObject2 = new StringBuilder().append("editVideoPrePublish: mHasRiched = ").append(bool).append(" , mUrl = ");
      if (localaypi.mUrl != null) {
        break label278;
      }
      localObject1 = "null";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareTitle = ");
      if (localaypi.zc != null) {
        break label288;
      }
      localObject1 = "null";
      label87:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareDesc = ");
      if (localaypi.aue != null) {
        break label298;
      }
      localObject1 = "null";
      label113:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(" , mShareThumb = ");
      if (localaypi.auf != null) {
        break label308;
      }
      localObject1 = "null";
      label139:
      ram.d("Q.qqstory.publish.editEditVideoLinker", (String)localObject1);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null) {
        break label350;
      }
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXN;
      str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXM;
      StringBuilder localStringBuilder = new StringBuilder().append("editVideoPrePublish: , sourceName = ");
      if (localObject1 != null) {
        break label318;
      }
      localObject2 = "null";
      label202:
      localStringBuilder = localStringBuilder.append((String)localObject2).append(" , sourceIconUrl = ");
      if (str != null) {
        break label325;
      }
      localObject2 = "null";
      label225:
      ram.d("Q.qqstory.publish.editEditVideoLinker", (String)localObject2);
    }
    for (;;)
    {
      if (bool) {}
      for (localObject1 = pty.a(localaypi.mUrl, localaypi.zc, localaypi.aue, str, (String)localObject1);; localObject1 = pty.a(localaypi.mUrl, true, str, (String)localObject1))
      {
        paramayqb.g.setLinkInfo((pty)localObject1);
        return;
        label278:
        localObject1 = localaypi.mUrl;
        break;
        label288:
        localObject1 = localaypi.zc;
        break label87;
        label298:
        localObject1 = localaypi.aue;
        break label113;
        label308:
        localObject1 = localaypi.auf;
        break label139;
        label318:
        localObject2 = localObject1;
        break label202;
        label325:
        localObject2 = str;
        break label225;
      }
      label350:
      localObject1 = null;
    }
  }
  
  public void a(aypi paramaypi)
  {
    String str = paramaypi.mUrl;
    if ((!TextUtils.isEmpty(str)) && (!this.qR.containsKey(str))) {
      this.qR.put(str, paramaypi);
    }
  }
  
  public void adz(String paramString)
  {
    aypi localaypi2 = (aypi)this.qR.get(paramString);
    aypi localaypi1 = localaypi2;
    if (localaypi2 == null) {
      localaypi1 = new aypi(paramString);
    }
    r("clk_added", getContext());
    eRB();
    rar.a("video_shoot", "exp_linkbar", 1, 0, new String[] { "", "", "", "" });
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setShowShare(false);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXM = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.cXN = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setLinkerObject(localaypi1);
    this.b.a(Message.obtain(null, 15, 1, 0));
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.editEditVideoLinker", 2, "editVideoLinker state : " + paramInt2);
      }
    }
    switch (paramInt2)
    {
    default: 
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setVisibility(4);
  }
  
  void eRB()
  {
    this.b.a().bsC();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView == null)
    {
      this.oj = ((RelativeLayout)y(2131366038));
      if (this.oj != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131298491) + wja.dp2px(17.0F, getResources()));
        i = 0;
      }
    }
    for (;;)
    {
      if (i < this.oj.getChildCount())
      {
        if (this.oj.getChildAt(i).getId() == 2131366040)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = new LinkerSummaryView(getContext());
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditVideoLinker(this);
          this.oj.addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView, i, localLayoutParams);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void eRC()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null)
    {
      this.oj.removeView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = null;
    }
    this.b.a(Message.obtain(null, 15, 0, 0));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView = null;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLinkerLinkerSummaryView.setEditing(false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.dzg) {
      return;
    }
    Looper.myQueue().addIdleHandler(new aygv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygu
 * JD-Core Version:    0.7.0.1
 */