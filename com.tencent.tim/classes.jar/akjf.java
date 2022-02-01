import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class akjf
  extends akhv
{
  public akjf(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(akhv.a parama)
  {
    return 5;
  }
  
  public akhv.a a()
  {
    return new akjf.a();
  }
  
  public View a(ViewGroup paramViewGroup, akhv.a parama)
  {
    paramViewGroup = (akjf.a)parama;
    parama = new TextView(this.mContext);
    parama.setTextColor(this.mContext.getResources().getColor(2131165381));
    parama.setTextSize(1, 16.0F);
    parama.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.Wh = parama;
    return parama;
  }
  
  public void h(akhv.a parama)
  {
    parama = (akjf.a)parama;
    Object localObject = (akjn)parama.b;
    String str = ((akjn)localObject).agQ;
    localObject = aqmw.a(this.mContext, ((akjn)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      parama.Wh.setVisibility(8);
      return;
    }
    parama.Wh.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      parama.Wh.setMovementMethod(LinkMovementMethod.getInstance());
    }
    parama.Wh.setText((CharSequence)localObject);
  }
  
  public class a
    extends akhv.a
  {
    public TextView Wh;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjf
 * JD-Core Version:    0.7.0.1
 */