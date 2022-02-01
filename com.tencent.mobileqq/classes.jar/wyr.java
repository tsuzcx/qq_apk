import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class wyr
  extends wyv
{
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = wnu.a(2131698599);
  }
  
  public wyr(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561785);
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
    b(zpp.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, wvn paramwvn)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
  
  public void a(wvn paramwvn)
  {
    super.a(paramwvn);
    yuk.a("FollowNodeViewHolder", "bindData %s", paramwvn);
    this.itemView.setTag(paramwvn.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((wtt)wth.a(2)).a(paramwvn.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (wyd.h)
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
        localObject1 = anzj.a(2131703567);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramwvn.c)) {
          localObject1 = paramwvn.c;
        }
        yuk.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramwvn.jdField_a_of_type_JavaLangString);
        wjj.a().dispatch(new wvm(paramwvn.jdField_a_of_type_JavaLangString));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.jdField_a_of_type_Boolean, paramwvn);
      a(paramwvn.g);
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
 * Qualified Name:     wyr
 * JD-Core Version:    0.7.0.1
 */