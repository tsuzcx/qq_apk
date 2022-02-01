import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class abeb
  extends abdu
  implements amkc, AbsListView.e
{
  private boolean bCa;
  private View.OnClickListener cX;
  private Drawable dC;
  private Context mContext;
  private LayoutInflater mInflater;
  private View.OnClickListener onItemClickListener;
  
  public abeb(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<amjz> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.onItemClickListener = paramOnClickListener1;
    this.cX = paramOnClickListener2;
    this.bCa = paramBoolean;
  }
  
  private void b(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.dC == null)
      {
        this.dC = paramTextView.getContext().getResources().getDrawable(2130842599);
        this.dC.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
      }
      ThemeUtil.setThemeFilter(this.dC, ThemeUtil.curThemeId);
      paramTextView.setCompoundDrawables(null, null, this.dC, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  protected boolean a(abdu.a parama)
  {
    boolean bool2 = super.a(parama);
    boolean bool1 = bool2;
    if ((parama instanceof abeb.a))
    {
      parama = (abeb.a)parama;
      if ((bool2) && (!parama.bAI)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void cBh()
  {
    super.cBh();
  }
  
  public void clear()
  {
    super.destory();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 5) {
      return 5;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    abeb.a locala;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2131559081, paramViewGroup, false);
      locala = new abeb.a();
      locala.xj = ((ImageView)paramView.findViewById(2131369780));
      locala.uT = ((ImageView)paramView.findViewById(2131369909));
      locala.jH = ((ImageView)paramView.findViewById(2131369756));
      locala.fe = ((TextView)paramView.findViewById(2131380814));
      locala.AA = paramView.findViewById(2131377412);
      locala.AA.setContentDescription(acfp.m(2131704460));
      amkl.O(locala.fe);
      locala.Pn = ((TextView)paramView.findViewById(2131380799));
      locala.Po = ((TextView)paramView.findViewById(2131381006));
      locala.Pp = ((TextView)paramView.findViewById(2131369782));
      locala.AB = paramView.findViewById(2131380904);
      paramView.setTag(locala);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (amjz)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      locala = (abeb.a)paramView.getTag();
    }
    Object localObject2 = ((amjz)localObject1).yV();
    locala.fe.setText((CharSequence)localObject2);
    if (String.valueOf(9954L).equals(((amjz)localObject1).getIdentifier())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      b(locala.fe, bool1);
      locala.Pn.setText(((amjz)localObject1).getExtraInfo());
      locala.uT.setImageResource(((amjz)localObject1).IO());
      locala.Po.setText(((amjz)localObject1).yU());
      locala.uin = ((amjz)localObject1).getIdentifier();
      locala.type = ((amjz)localObject1).pG();
      if ((localObject1 instanceof amjl))
      {
        SearchHistory localSearchHistory = ((amjl)localObject1).a();
        bool1 = bool2;
        if (localSearchHistory.type != 56938)
        {
          if (localSearchHistory.type != 56942) {
            break label574;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        label381:
        locala.bAI = bool1;
        if (locala.bAI)
        {
          locala.xj.setImageResource(2130842937);
          locala.Pp.setVisibility(0);
          locala.Pp.setText(aqgv.ps((String)localObject2));
          label429:
          localObject2 = ((amjz)localObject1).aP();
          if (localObject2 != null) {
            break label615;
          }
          locala.jH.setVisibility(8);
          label451:
          if (this.onItemClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.onItemClickListener);
          }
          if (this.cX != null)
          {
            locala.AA.setTag(-1, Long.valueOf(((SearchHistory)((amjz)localObject1).R()).getId()));
            locala.AA.setOnClickListener(this.cX);
          }
          localObject1 = paramView.findViewById(2131366004);
          if (paramInt != getCount() - 1) {
            break label637;
          }
          ((View)localObject1).setVisibility(8);
          label543:
          if (locala.AB != null)
          {
            if (!amkl.gM(locala.uin)) {
              break label646;
            }
            locala.AB.setVisibility(0);
          }
        }
        for (;;)
        {
          break;
          label574:
          bool1 = false;
          break label381;
          locala.xj.setImageBitmap(e(locala.uin, locala.type));
          locala.Pp.setVisibility(8);
          break label429;
          label615:
          locala.jH.setVisibility(0);
          locala.jH.setImageDrawable((Drawable)localObject2);
          break label451;
          label637:
          ((View)localObject1).setVisibility(0);
          break label543;
          label646:
          locala.AB.setVisibility(8);
        }
        bool1 = false;
      }
    }
  }
  
  public static class a
    extends abdu.a
  {
    public View AA;
    public View AB;
    public TextView Pn;
    public TextView Po;
    public TextView Pp;
    public boolean bAI;
    public TextView fe;
    public ImageView jH;
    public ImageView uT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abeb
 * JD-Core Version:    0.7.0.1
 */