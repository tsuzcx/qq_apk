import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class vbk
  extends vbo
{
  public static final String a;
  public QQUserUIItem a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a(2131700066);
  }
  
  public vbk(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561509);
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
    b(xsj.b(paramString));
  }
  
  protected void a(String paramString, boolean paramBoolean, uyg paramuyg)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018WidgetsStoryMsgNodeFrameLayout.setNodeName(paramString, paramBoolean);
  }
  
  public void a(uyg paramuyg)
  {
    super.a(paramuyg);
    wxe.a("FollowNodeViewHolder", "bindData %s", paramuyg);
    this.itemView.setTag(paramuyg.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((uwm)uwa.a(2)).a(paramuyg.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (vaw.h)
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
        localObject1 = alud.a(2131705064);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramuyg.c)) {
          localObject1 = paramuyg.c;
        }
        wxe.a("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, paramuyg.jdField_a_of_type_JavaLangString);
        umc.a().dispatch(new uyf(paramuyg.jdField_a_of_type_JavaLangString));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.jdField_a_of_type_Boolean, paramuyg);
      a(paramuyg.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbk
 * JD-Core Version:    0.7.0.1
 */