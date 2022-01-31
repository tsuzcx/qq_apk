import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class tim
  extends tiq
{
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxp.a(2131699675);
  }
  
  public tim(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561302);
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
    b(vzl.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, tfi paramtfi)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
  
  public void a(tfi paramtfi)
  {
    super.a(paramtfi);
    veg.a("FollowNodeViewHolder", "bindData %s", paramtfi);
    this.itemView.setTag(paramtfi.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((tdo)tdc.a(2)).a(paramtfi.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (thy.h)
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
        localObject1 = ajyc.a(2131704669);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramtfi.c)) {
          localObject1 = paramtfi.c;
        }
        veg.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramtfi.jdField_a_of_type_JavaLangString);
        ste.a().dispatch(new tfh(paramtfi.jdField_a_of_type_JavaLangString));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.jdField_a_of_type_Boolean, paramtfi);
      a(paramtfi.g);
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
 * Qualified Name:     tim
 * JD-Core Version:    0.7.0.1
 */