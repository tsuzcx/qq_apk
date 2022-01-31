import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class tij
  extends tin
{
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a(2131699686);
  }
  
  public tij(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561301);
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
    b(vzi.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, tff paramtff)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
  
  public void a(tff paramtff)
  {
    super.a(paramtff);
    ved.a("FollowNodeViewHolder", "bindData %s", paramtff);
    this.itemView.setTag(paramtff.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdl)tcz.a(2)).a(paramtff.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (thv.h)
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
        localObject1 = ajya.a(2131704680);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramtff.c)) {
          localObject1 = paramtff.c;
        }
        ved.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramtff.jdField_a_of_type_JavaLangString);
        stb.a().dispatch(new tfe(paramtff.jdField_a_of_type_JavaLangString));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.jdField_a_of_type_Boolean, paramtff);
      a(paramtff.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tij
 * JD-Core Version:    0.7.0.1
 */