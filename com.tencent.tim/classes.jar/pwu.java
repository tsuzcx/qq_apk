import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class pwu
  extends pwp
{
  private boolean mIsVip;
  
  public pwu(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561902);
  }
  
  private void c(puh parampuh, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      u(parampuh);
      return;
      super.s(parampuh);
      this.a.bnf();
      continue;
      super.s(parampuh);
      this.a.bne();
      continue;
      super.s(parampuh);
      this.a.bnf();
    }
  }
  
  private void u(puh parampuh)
  {
    if ((parampuh.isUploading) || (parampuh.bkt > 0))
    {
      rt(parampuh.avv);
      if ((!parampuh.isUploading) && (parampuh.bkt > 0)) {
        this.a.setDisplayState(1);
      }
      for (;;)
      {
        ram.d("VASH", "bindCoverImage: %s", parampuh.avv);
        return;
        this.a.setDisplayState(0);
      }
    }
    rt(rpn.gn(parampuh.videoCover));
    ram.d("VASH", "bindCoverImage: %s", parampuh.videoCover);
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(parampuh.uid);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (ptf)psx.a(2);
      localObject2 = QQStoryContext.a().getCurrentUid();
      localObject3 = ((ptf)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new QQUserUIItem.a(String.valueOf(localObject1), "");
        new pxs().a(0, (QQUserUIItem.a)localObject2, String.valueOf(localObject1));
      }
      if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
        break label252;
      }
      bool = true;
      label141:
      this.mIsVip = bool;
      if (!this.mIsVip) {
        break label257;
      }
    }
    label257:
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = acfp.m(2131714255))
    {
      this.a.setNodeName((String)localObject1, this.mIsVip);
      u(parampuh);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(parampuh.isUploading), ", unUploadVideoCount: ", Integer.valueOf(parampuh.bkt) });
      }
      return;
      label223:
      localObject1 = new QQUserUIItem.a("", (String)localObject2);
      new pxs().a(1, (QQUserUIItem.a)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void s(puh parampuh)
  {
    ram.d("VASH", "My bindImage of data: %s", String.valueOf(parampuh));
    if (parampuh.isUploading) {
      c(parampuh, 1);
    }
    for (;;)
    {
      this.a.n(parampuh);
      return;
      if (parampuh.bkt > 0) {
        c(parampuh, 2);
      } else {
        c(parampuh, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwu
 * JD-Core Version:    0.7.0.1
 */