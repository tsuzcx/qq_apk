import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class amtj
  implements amsq<ampv, amxx>
{
  public void a(ampv paramampv, amxx paramamxx)
  {
    amzh localamzh = (amzh)paramamxx;
    ampf localampf;
    Object localObject;
    if ((paramampv instanceof ampf))
    {
      localampf = (ampf)paramampv;
      localObject = localampf.getGroupName();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label342;
      }
      localObject = "";
    }
    label203:
    label337:
    label342:
    for (;;)
    {
      if (((ampf)paramampv).awf())
      {
        String str = localampf.getKeyword();
        if (!TextUtils.isEmpty(str))
        {
          str = amxk.a(localamzh.getTitleView(), 10.0F * amxk.a(localamzh.getTitleView(), acfp.m(2131714132)), 1, str, str, false, false, true).toString();
          localObject = new SpannableString(str + "-" + (String)localObject);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#12B7F5")), 0, str.length(), 34);
          localamzh.getTitleView().setText((CharSequence)localObject);
          if (!localampf.awe()) {
            break label312;
          }
          paramamxx.R().setText(localampf.ze());
          paramamxx.R().setVisibility(0);
          paramamxx.R().setTag(2131381961, Integer.valueOf(-1));
          if ((paramampv instanceof ampw))
          {
            paramampv = (ampw)paramampv;
            paramamxx.R().setOnClickListener(new amtk(this, paramampv));
          }
          paramampv = paramamxx.getView().getTag(2131381961);
          if (!(paramampv instanceof Integer)) {
            break label337;
          }
        }
      }
      for (int i = ((Integer)paramampv).intValue();; i = -1)
      {
        if (i > 0) {
          localamzh.PB(true);
        }
        while (i != 0)
        {
          return;
          localamzh.getTitleView().setText((CharSequence)localObject);
          break;
          localamzh.getTitleView().setText((CharSequence)localObject);
          break;
          paramamxx.R().setVisibility(8);
          break label203;
        }
        localamzh.PB(false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtj
 * JD-Core Version:    0.7.0.1
 */