import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wpl
  extends wpg
{
  private boolean a;
  
  public wpl(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561731);
  }
  
  private void a(wly paramwly, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramwly);
      return;
      super.b(paramwly);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramwly);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramwly);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(wly paramwly)
  {
    if ((paramwly.jdField_b_of_type_Boolean) || (paramwly.d > 0))
    {
      b(paramwly.h);
      if ((!paramwly.jdField_b_of_type_Boolean) && (paramwly.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        ykq.b("VASH", "bindCoverImage: %s", paramwly.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(zfe.b(paramwly.g));
    ykq.b("VASH", "bindCoverImage: %s", paramwly.g);
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramwly.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (wke)wjs.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((wke)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new wkz(String.valueOf(localObject1), "");
        new wrb().a(0, (wkz)localObject2, String.valueOf(localObject1));
      }
      if ((localObject3 == null) || (!((QQUserUIItem)localObject3).isVip())) {
        break label252;
      }
      bool = true;
      label141:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label257;
      }
    }
    label257:
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = anvx.a(2131713233))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramwly);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramwly.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramwly.d) });
      }
      return;
      label223:
      localObject1 = new wkz("", (String)localObject2);
      new wrb().a(1, (wkz)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(wly paramwly)
  {
    ykq.b("VASH", "My bindImage of data: %s", String.valueOf(paramwly));
    if (paramwly.jdField_b_of_type_Boolean) {
      a(paramwly, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwly);
      return;
      if (paramwly.d > 0) {
        a(paramwly, 2);
      } else {
        a(paramwly, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */