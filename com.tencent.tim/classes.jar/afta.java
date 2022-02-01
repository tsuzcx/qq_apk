import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class afta
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public awnr a;
  public ExtendFriendFeedView a;
  afwg b;
  private Context mContext;
  
  public afta(View paramView, Context paramContext, afwg paramafwg, awnr paramawnr)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Awnr = paramawnr;
    this.mContext = paramContext;
    this.b = paramafwg;
    if (this.jdField_a_of_type_Awnr != null) {
      this.jdField_a_of_type_Awnr.a(this.jdField_a_of_type_Awnr.getView(), new aftb(this));
    }
  }
  
  public void a(afta paramafta, afua paramafua, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramafua != null))
    {
      int i = paramafta.getPosition();
      paramafta.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramafua.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Awnr != null) && (paramafua != null) && (paramafua.mAlumbasicdata != null)) {
      paramafta.jdField_a_of_type_Awnr.a(paramafua.mAlumbasicdata, paramafta.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afta
 * JD-Core Version:    0.7.0.1
 */