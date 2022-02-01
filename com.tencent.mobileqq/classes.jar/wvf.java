import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wvf
  extends wva
{
  private boolean a;
  
  public wvf(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561744);
  }
  
  private void a(wrs paramwrs, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramwrs);
      return;
      super.b(paramwrs);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramwrs);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramwrs);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(wrs paramwrs)
  {
    if ((paramwrs.jdField_b_of_type_Boolean) || (paramwrs.d > 0))
    {
      b(paramwrs.h);
      if ((!paramwrs.jdField_b_of_type_Boolean) && (paramwrs.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        yqp.b("VASH", "bindCoverImage: %s", paramwrs.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(zlu.b(paramwrs.g));
    yqp.b("VASH", "bindCoverImage: %s", paramwrs.g);
  }
  
  public void a(wrs paramwrs)
  {
    super.a(paramwrs);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramwrs.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (wpy)wpm.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((wpy)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new wqt(String.valueOf(localObject1), "");
        new wwv().a(0, (wqt)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = anni.a(2131712545))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramwrs);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramwrs.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramwrs.d) });
      }
      return;
      label223:
      localObject1 = new wqt("", (String)localObject2);
      new wwv().a(1, (wqt)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(wrs paramwrs)
  {
    yqp.b("VASH", "My bindImage of data: %s", String.valueOf(paramwrs));
    if (paramwrs.jdField_b_of_type_Boolean) {
      a(paramwrs, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwrs);
      return;
      if (paramwrs.d > 0) {
        a(paramwrs, 2);
      } else {
        a(paramwrs, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wvf
 * JD-Core Version:    0.7.0.1
 */