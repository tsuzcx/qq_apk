import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wza
  extends wyv
{
  private boolean a;
  
  public wza(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561785);
  }
  
  private void a(wvn paramwvn, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c(paramwvn);
      return;
      super.b(paramwvn);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
      continue;
      super.b(paramwvn);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a();
      continue;
      super.b(paramwvn);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.b();
    }
  }
  
  private void c(wvn paramwvn)
  {
    if ((paramwvn.jdField_b_of_type_Boolean) || (paramwvn.d > 0))
    {
      b(paramwvn.h);
      if ((!paramwvn.jdField_b_of_type_Boolean) && (paramwvn.d > 0)) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(1);
      }
      for (;;)
      {
        yuk.b("VASH", "bindCoverImage: %s", paramwvn.h);
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setDisplayState(0);
      }
    }
    b(zpp.b(paramwvn.g));
    yuk.b("VASH", "bindCoverImage: %s", paramwvn.g);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3;
    Object localObject2;
    boolean bool;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject3 = (QQAppInterface)localObject1;
      localObject2 = String.valueOf(paramwvn.jdField_b_of_type_Long);
      localObject1 = localObject2;
      if ("0".equals(localObject2)) {
        localObject1 = ((QQAppInterface)localObject3).getCurrentAccountUin();
      }
      localObject3 = (wtt)wth.a(2);
      localObject2 = QQStoryContext.a().b();
      localObject3 = ((wtt)localObject3).b((String)localObject2);
      if (localObject3 == null)
      {
        if (!"0_1000".equals(localObject2)) {
          break label223;
        }
        localObject2 = new wuo(String.valueOf(localObject1), "");
        new xaq().a(0, (wuo)localObject2, String.valueOf(localObject1));
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
    for (localObject1 = ((QQUserUIItem)localObject3).nickName;; localObject1 = anzj.a(2131712654))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName((String)localObject1, this.jdField_a_of_type_Boolean);
      c(paramwvn);
      if (QLog.isDevelopLevel()) {
        QLog.d("SelfNodeViewHolder", 2, new Object[] { "update self view, isUploading:", Boolean.valueOf(paramwvn.jdField_b_of_type_Boolean), ", unUploadVideoCount: ", Integer.valueOf(paramwvn.d) });
      }
      return;
      label223:
      localObject1 = new wuo("", (String)localObject2);
      new xaq().a(1, (wuo)localObject1, (String)localObject2);
      break;
      label252:
      bool = false;
      break label141;
    }
  }
  
  protected void b(wvn paramwvn)
  {
    yuk.b("VASH", "My bindImage of data: %s", String.valueOf(paramwvn));
    if (paramwvn.jdField_b_of_type_Boolean) {
      a(paramwvn, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.a(paramwvn);
      return;
      if (paramwvn.d > 0) {
        a(paramwvn, 2);
      } else {
        a(paramwvn, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wza
 * JD-Core Version:    0.7.0.1
 */