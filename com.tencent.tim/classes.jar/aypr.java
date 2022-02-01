import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aypr
  extends aypv
{
  private QQAppInterface mApp;
  private List<aypr.b> oW;
  
  public aypr(Context paramContext, String paramString1, String paramString2, int paramInt, @NonNull List<aypr.b> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString1, paramString2, paramInt);
    this.oW = paramList;
    this.mApp = paramQQAppInterface;
  }
  
  private aypr.c a(int paramInt)
  {
    int i = getLineCount();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new aypr.c(null);
      ((aypr.c)localObject1).type = 1;
      return localObject1;
    }
    Object localObject2 = this.oW.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (aypr.b)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new aypr.c(null);
        ((aypr.c)localObject2).type = 2;
        ((aypr.c)localObject2).b = ((aypr.b)localObject1);
        return localObject2;
      }
      if (!aypr.b.a((aypr.b)localObject1)) {
        break label253;
      }
      if (paramInt <= ((aypr.b)localObject1).cg().size() + i)
      {
        localObject2 = (aypr.a)((aypr.b)localObject1).cg().get(paramInt - i - 1);
        aypr.c localc = new aypr.c(null);
        localc.type = 3;
        localc.b = ((aypr.b)localObject1);
        localc.a = ((aypr.a)localObject2);
        return localc;
      }
      i = ((aypr.b)localObject1).cg().size() + i;
    }
    label253:
    for (;;)
    {
      break;
      throw new IllegalStateException("can not find item with innerPos:" + paramInt);
    }
  }
  
  private void a(View paramView, aypr.b paramb)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131368187);
    TextView localTextView2 = (TextView)paramView.findViewById(2131368190);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131368158);
    paramView = (CheckBox)paramView.findViewById(2131368160);
    localTextView1.setText(paramb.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(paramb.tA()), Integer.valueOf(paramb.tB()) }));
    if (paramb.tB() == 0)
    {
      paramView.setVisibility(4);
      if (!paramb.LF()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!aypr.b.a(paramb)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new ayps(this, paramb));
      return;
      paramView.setVisibility(0);
      break;
      label146:
      paramView.setChecked(false);
      break label111;
      label154:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, aypr.b paramb, aypr.a parama)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131367680);
    Object localObject1 = (TextView)paramView.findViewById(2131367700);
    Object localObject2 = (CheckBox)paramView.findViewById(2131367663);
    paramView = paramView.findViewById(2131367662);
    ((TextView)localObject1).setText(parama.b.remark);
    if (parama.mIsSelected)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = aqhu.at();
      if (this.mApp == null) {
        break label224;
      }
      localObject2 = aqdj.a(this.mApp, 1, parama.b.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.oW.indexOf(paramb) == this.oW.size() - 1)
      {
        paramb = paramb.cg();
        if (paramb.indexOf(parama) == paramb.size() - 1)
        {
          int i = -2170912;
          QQStoryContext.a();
          if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
            i = -16444373;
          }
          paramView.setBackgroundColor(i);
          paramView.setVisibility(0);
        }
      }
      return;
      ((CheckBox)localObject2).setChecked(false);
      break;
      label207:
      ram.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label224:
      ram.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(aypr.c paramc)
  {
    boolean bool;
    if (this.aHE) {
      if (!this.isOpen) {
        bool = true;
      }
    }
    for (this.isOpen = bool;; this.isOpen = true)
    {
      this.aHE = true;
      return;
      bool = false;
      break;
    }
  }
  
  private void b(aypr.c paramc)
  {
    paramc.b.onClick();
  }
  
  private void c(aypr.c paramc)
  {
    paramc.b.a(paramc.a);
  }
  
  private void dR(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131364343);
    Object localObject = (ImageView)paramView.findViewById(2131364353);
    TextView localTextView = (TextView)paramView.findViewById(2131364350);
    paramView = paramView.findViewById(2131364344);
    localTextView.setText(this.aAS);
    if (this.aHE)
    {
      ((ImageView)localObject).setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (!this.isOpen) {
        break label143;
      }
      localCheckBox.setChecked(true);
    }
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = rpq.dip2px(this.context, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
        i = -16444373;
      }
      paramView.setBackgroundColor(i);
      return;
      ((ImageView)localObject).setVisibility(4);
      break;
      label143:
      localCheckBox.setChecked(false);
    }
  }
  
  private int getLineCount()
  {
    if (!this.isOpen) {
      return 1;
    }
    Iterator localIterator = this.oW.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      aypr.b localb = (aypr.b)localIterator.next();
      List localList = localb.cg();
      i += 1;
      if (!aypr.b.a(localb)) {
        break label72;
      }
      i = localList.size() + i;
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int J(int paramInt)
  {
    return a(paramInt).type;
  }
  
  @NonNull
  public List<aypr.a> cf()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.oW.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((aypr.b)localIterator.next()).cf());
    }
    return localArrayList;
  }
  
  public View d(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt).type)
    {
    default: 
      return null;
    case 1: 
      return LayoutInflater.from(this.context).inflate(2131561914, null);
    case 2: 
      return LayoutInflater.from(this.context).inflate(2131561916, null);
    }
    return LayoutInflater.from(this.context).inflate(2131561915, null);
  }
  
  public void eV(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.oW.iterator();
    while (localIterator1.hasNext())
    {
      aypr.b localb = (aypr.b)localIterator1.next();
      Iterator localIterator2 = localb.cg().iterator();
      while (localIterator2.hasNext())
      {
        aypr.a locala = (aypr.a)localIterator2.next();
        if (paramList.contains(locala.getUin())) {
          localb.b(locala);
        }
      }
    }
  }
  
  public void m(int paramInt, View paramView)
  {
    aypr.c localc = a(paramInt);
    switch (localc.type)
    {
    default: 
      return;
    case 1: 
      dR(paramView);
      return;
    case 2: 
      a(paramView, localc.b);
      return;
    }
    a(paramView, localc.b, localc.a);
  }
  
  public void onClick(int paramInt)
  {
    aypr.c localc = a(paramInt);
    switch (localc.type)
    {
    default: 
      return;
    case 1: 
      a(localc);
      return;
    case 2: 
      b(localc);
      return;
    }
    c(localc);
  }
  
  public int tz()
  {
    return getLineCount();
  }
  
  public static class a
  {
    @NonNull
    protected final Friends b;
    protected boolean mIsSelected;
    
    public a(@NonNull Friends paramFriends)
    {
      this.b = paramFriends;
    }
    
    public String getUin()
    {
      return this.b.uin;
    }
    
    public void onClick()
    {
      if (!this.mIsSelected) {}
      for (boolean bool = true;; bool = false)
      {
        this.mIsSelected = bool;
        return;
      }
    }
  }
  
  public static class b
  {
    @NonNull
    protected final Groups a;
    private boolean mIsOpen;
    @NonNull
    private final List<aypr.a> oX;
    @NonNull
    private final List<aypr.a> oY = new ArrayList();
    
    public b(@NonNull Groups paramGroups, @NonNull List<aypr.a> paramList)
    {
      this.a = paramGroups;
      this.oX = paramList;
      paramGroups = paramList.iterator();
      while (paramGroups.hasNext())
      {
        paramList = (aypr.a)paramGroups.next();
        if (paramList.mIsSelected) {
          this.oY.add(paramList);
        }
      }
    }
    
    public boolean LF()
    {
      return (!this.oY.isEmpty()) && (this.oX.size() == this.oY.size());
    }
    
    public void a(aypr.a parama)
    {
      parama.onClick();
      if ((parama.mIsSelected) && (!this.oY.contains(parama)))
      {
        this.oY.add(parama);
        return;
      }
      if ((!parama.mIsSelected) && (this.oY.contains(parama)))
      {
        this.oY.remove(parama);
        return;
      }
      throw new IllegalStateException("onFriendClick, friend select:" + parama.mIsSelected + ",contains:" + this.oY.contains(parama));
    }
    
    public void b(aypr.a parama)
    {
      parama.mIsSelected = true;
      if (!this.oY.contains(parama)) {
        this.oY.add(parama);
      }
    }
    
    public void bvi()
    {
      this.oY.clear();
      Iterator localIterator = this.oX.iterator();
      while (localIterator.hasNext()) {
        ((aypr.a)localIterator.next()).mIsSelected = false;
      }
    }
    
    @NonNull
    public List<aypr.a> cf()
    {
      return Collections.unmodifiableList(this.oY);
    }
    
    @NonNull
    public List<aypr.a> cg()
    {
      return Collections.unmodifiableList(this.oX);
    }
    
    public void onClick()
    {
      if (!this.mIsOpen) {}
      for (boolean bool = true;; bool = false)
      {
        this.mIsOpen = bool;
        return;
      }
    }
    
    public void selectAll()
    {
      this.oY.clear();
      Iterator localIterator = this.oX.iterator();
      while (localIterator.hasNext())
      {
        aypr.a locala = (aypr.a)localIterator.next();
        locala.mIsSelected = true;
        this.oY.add(locala);
      }
    }
    
    public int tA()
    {
      return this.oY.size();
    }
    
    public int tB()
    {
      return this.oX.size();
    }
  }
  
  static class c
  {
    aypr.a a;
    aypr.b b;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypr
 * JD-Core Version:    0.7.0.1
 */