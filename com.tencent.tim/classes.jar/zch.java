import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class zch
  extends yzr
{
  private static final int[] fA = { 2131371299 };
  private static final int[] fy = { 2131694512 };
  private static final int[] fz = { 2130839770 };
  private acdu b;
  private int ccV;
  
  public zch(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.ccV = paramInt;
    this.a = a(this.mContext);
    if (paramInt == 2) {
      this.b = ((acdu)paramQQAppInterface.getManager(53));
    }
    this.mMenuFlag = 0;
  }
  
  protected int[] F()
  {
    return fA;
  }
  
  protected int[] G()
  {
    return fy;
  }
  
  protected int[] H()
  {
    return fz;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof zch.a)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559250, null);
      paramViewGroup = new zch.a();
      paramView = this.a.a(this.mContext, paramView, paramViewGroup, -1);
      paramViewGroup.BM = ((TextView)paramView.findViewById(2131379402));
      paramViewGroup.pQ = ((ImageView)paramView.findViewById(2131368698));
      ((RelativeLayout.LayoutParams)paramViewGroup.pQ.getLayoutParams()).leftMargin = wja.dp2px(12.0F, this.mContext.getResources());
      paramViewGroup.Mt = ((TextView)paramView.findViewById(2131379404));
      paramView.setTag(paramViewGroup);
      paramViewGroup.Lz.setBackgroundResource(2130839642);
      if (this.ccV != 2) {
        break label279;
      }
      localObject = (DiscussionInfo)this.c;
      paramViewGroup.uin = ((DiscussionInfo)localObject).uin;
      paramViewGroup.item = localObject;
      paramViewGroup.type = 101;
      paramViewGroup.BM.setText(((DiscussionInfo)localObject).discussionName);
      paramViewGroup.Mt.setVisibility(0);
      paramViewGroup.Mt.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.b.cn(((DiscussionInfo)localObject).uin)) }));
    }
    for (;;)
    {
      paramViewGroup.BM.setTextColor(this.mContext.getResources().getColor(2131167311));
      a(paramView, paramInt2, paramViewGroup, paramOnClickListener);
      return paramView;
      paramViewGroup = (zch.a)paramView.getTag();
      break;
      label279:
      localObject = (TroopInfo)this.c;
      paramViewGroup.uin = ((TroopInfo)localObject).troopuin;
      paramViewGroup.item = localObject;
      paramViewGroup.type = 4;
      paramViewGroup.BM.setText(((TroopInfo)localObject).getTroopName());
      paramViewGroup.Mt.setVisibility(8);
    }
  }
  
  protected void a(int paramInt, auvd.b[] paramArrayOfb)
  {
    paramInt = 0;
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfb.length < 0)
      {
        paramArrayOfb[0].dOf = 0;
        paramArrayOfb[0].dOe = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfb.length)
      {
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
        paramInt += 1;
      }
    }
  }
  
  public static class a
    extends yzr.b
  {
    public TextView BM;
    public TextView Mt;
    public TextView Mu;
    public boolean bqG;
    public int ccW;
    public ImageView uT;
    public ImageView uU;
    public ImageView uV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zch
 * JD-Core Version:    0.7.0.1
 */