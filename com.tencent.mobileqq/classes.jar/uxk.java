import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class uxk
  extends uxf
{
  private boolean a;
  
  public uxk(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561491);
  }
  
  private void a(utx paramutx, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramutx);
      return;
      super.b(paramutx);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramutx);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramutx);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(utx paramutx)
  {
    if ((paramutx.jdField_b_of_type_Boolean) || (paramutx.d > 0))
    {
      b(paramutx.h);
      if ((!paramutx.jdField_b_of_type_Boolean) && (paramutx.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        wsv.b("VASH", "bindCoverImage: %s", paramutx.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(xoa.b(paramutx.g));
    wsv.b("VASH", "bindCoverImage: %s", paramutx.g);
  }
  
  public void a(utx paramutx)
  {
    super.a(paramutx);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramutx.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (usd)urr.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((usd)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new usy(String.valueOf(localObject1), "");
        new uza().a(0, (usy)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = alpo.a(2131714161))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramutx);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramutx.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramutx.d) });
      }
      return;
      label223:
      localObject1 = new usy("", (String)localObject2);
      new uza().a(1, (usy)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(utx paramutx)
  {
    wsv.b("VASH", "My bindImage of data: %s", String.valueOf(paramutx));
    if (paramutx.jdField_b_of_type_Boolean) {
      a(paramutx, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramutx);
      return;
      if (paramutx.d > 0) {
        a(paramutx, 2);
      } else {
        a(paramutx, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxk
 * JD-Core Version:    0.7.0.1
 */