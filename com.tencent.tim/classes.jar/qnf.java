import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class qnf
  extends qmm.b
{
  private boolean aEu;
  private String axL = "";
  private pty jdField_c_of_type_Pty;
  private qjq jdField_c_of_type_Qjq;
  
  public boolean F(View paramView)
  {
    if ((this.jdField_c_of_type_Pty == null) || (this.jdField_c_of_type_Pty.styleType != 1)) {
      return false;
    }
    if (!super.F(paramView)) {
      return false;
    }
    if (this.jdField_c_of_type_Pty.linkUrl.startsWith("mqqapi:"))
    {
      paramView = aqik.c(QQStoryContext.a(), this.b.getActivity(), this.jdField_c_of_type_Pty.linkUrl);
      if (paramView != null) {
        paramView.ace();
      }
      return true;
    }
    paramView = new Intent(this.b.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_c_of_type_Pty.aL());
    this.b.getActivity().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_c_of_type_Pty.iconUrl)) {}
    for (paramView = "2";; paramView = "1")
    {
      rar.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.axL });
      return true;
    }
  }
  
  public Map<Subscriber, String> N()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new qnf.a(this), "");
    return localHashMap;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    this.jdField_c_of_type_Qjq = paramqjq;
    StoryVideoItem localStoryVideoItem = paramqjq.b();
    pty localpty = localStoryVideoItem.getVideoLinkInfo();
    if ((localpty == null) || (localpty.styleType != 1))
    {
      this.b.hide();
      this.jdField_c_of_type_Qjq = null;
      return;
    }
    if (TextUtils.equals(this.axL, paramqjq.vid))
    {
      this.aEu = false;
      this.jdField_c_of_type_Pty = localpty;
      this.b.show();
      paramc.xj.setVisibility(0);
      paramc.content.setVisibility(0);
      paramc.imageView.setVisibility(0);
      if (TextUtils.isEmpty(localpty.avn)) {
        break label184;
      }
      paramc.xj.setText(localpty.avn);
    }
    for (;;)
    {
      paramc.content.setText(localpty.mD());
      paramc.content.setContentDescription(null);
      if ((localpty.bkq != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramc.imageView.setImageResource(2130847502);
      return;
      this.aEu = true;
      this.axL = paramqjq.vid;
      break;
      label184:
      paramc.xj.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localpty.iconUrl))
    {
      paramc.imageView.setImageResource(2130840151);
      return;
    }
    qmm.a(localpty.iconUrl, paramc.imageView, paramc.defaultDrawable, paramc.bnm, paramc.bnm);
  }
  
  public static class a
    extends QQUIEventReceiver<qnf, pnx.d>
  {
    public a(@NonNull qnf paramqnf)
    {
      super();
    }
    
    public void a(@NonNull qnf paramqnf, @NonNull pnx.d paramd)
    {
      if ((qnf.a(paramqnf) == null) || (paramd.b == null) || (!TextUtils.equals(qnf.a(paramqnf).vid, paramd.b.mVid))) {
        return;
      }
      paramqnf.b.updateUI();
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qnf
 * JD-Core Version:    0.7.0.1
 */