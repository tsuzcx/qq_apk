package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import aqnm;
import avtf;
import avts;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import java.util.ArrayList;

public class MsgMoreView
  extends FrameLayout
{
  private static final int eyz = aqnm.dpToPx(24.0F);
  private avts jdField_a_of_type_Avts;
  private MQMsg jdField_a_of_type_CooperationQzoneContentboxModelMQMsg;
  private FrameLayout cx;
  private Context mContext;
  
  public MsgMoreView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131562596, this);
    this.cx = ((FrameLayout)findViewById(2131363201));
    setOnClickListener(new avtf(this));
  }
  
  public void setData(MQMsg paramMQMsg, boolean paramBoolean)
  {
    int j = 0;
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = paramMQMsg;
    paramMQMsg = paramMQMsg.bottomCell;
    if (paramMQMsg.userAvatar != null)
    {
      this.cx.setVisibility(0);
      this.cx.removeAllViews();
      int i;
      if (5 < paramMQMsg.userAvatar.size()) {
        i = 5;
      }
      while (j < i)
      {
        UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1);
        localUserListItemView.setUin((String)paramMQMsg.userAvatar.get(j));
        localUserListItemView.setTranslationX(eyz * j);
        if ((j == i - 1) && (paramMQMsg.total - i > 0)) {
          localUserListItemView.vb(true);
        }
        this.cx.addView(localUserListItemView, j);
        j += 1;
        continue;
        i = paramMQMsg.userAvatar.size();
      }
    }
    if (paramBoolean) {
      ((TextView)findViewById(2131371970)).setTextColor(-7500397);
    }
  }
  
  public void setMsgOnClickListener(avts paramavts)
  {
    this.jdField_a_of_type_Avts = paramavts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreView
 * JD-Core Version:    0.7.0.1
 */