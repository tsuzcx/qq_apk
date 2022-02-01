import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class waq
  extends wal
{
  private boolean a;
  
  public waq(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561663);
  }
  
  private void a(vxd paramvxd, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramvxd);
      return;
      super.b(paramvxd);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramvxd);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramvxd);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(vxd paramvxd)
  {
    if ((paramvxd.jdField_b_of_type_Boolean) || (paramvxd.d > 0))
    {
      b(paramvxd.h);
      if ((!paramvxd.jdField_b_of_type_Boolean) && (paramvxd.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        xvv.b("VASH", "bindCoverImage: %s", paramvxd.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(yql.b(paramvxd.g));
    xvv.b("VASH", "bindCoverImage: %s", paramvxd.g);
  }
  
  public void a(vxd paramvxd)
  {
    super.a(paramvxd);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramvxd.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (vvj)vux.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((vvj)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new vwe(String.valueOf(localObject1), "");
        new wcg().a(0, (vwe)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = amtj.a(2131712886))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramvxd);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramvxd.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramvxd.d) });
      }
      return;
      label223:
      localObject1 = new vwe("", (String)localObject2);
      new wcg().a(1, (vwe)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(vxd paramvxd)
  {
    xvv.b("VASH", "My bindImage of data: %s", String.valueOf(paramvxd));
    if (paramvxd.jdField_b_of_type_Boolean) {
      a(paramvxd, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramvxd);
      return;
      if (paramvxd.d > 0) {
        a(paramvxd, 2);
      } else {
        a(paramvxd, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */