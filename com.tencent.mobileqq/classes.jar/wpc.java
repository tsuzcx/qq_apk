import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class wpc
  extends wpg
{
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = weg.a(2131699185);
  }
  
  public wpc(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561731);
  }
  
  protected String a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return null;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  protected void a(String paramString)
  {
    b(zfe.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, wly paramwly)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
  
  public void a(wly paramwly)
  {
    super.a(paramwly);
    ykq.a("FollowNodeViewHolder", "bindData %s", paramwly);
    this.itemView.setTag(paramwly.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wke)wjs.a(2)).a(paramwly.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (woo.h)
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVipButNoFriend()))
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      localObject2 = a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      if (!this.jdField_a_of_type_Boolean) {
        break label194;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = anvx.a(2131704148);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramwly.c)) {
          localObject1 = paramwly.c;
        }
        ykq.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramwly.jdField_a_of_type_JavaLangString);
        wad.a().dispatch(new wlx(paramwly.jdField_a_of_type_JavaLangString));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.jdField_a_of_type_Boolean, paramwly);
      a(paramwly.g);
      return;
      bool = false;
      break;
      label194:
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpc
 * JD-Core Version:    0.7.0.1
 */