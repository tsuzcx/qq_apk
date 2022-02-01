package com.tencent.token.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.abu;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.PullToRefreshListView.a;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ShowLogActivity
  extends BaseActivity
{
  private static final int CAPACITY = 1024;
  private static final int MAX_LOG_PAGECOUNT = 2;
  private static final int MENU_CLEARLOG = 3;
  private static final int MENU_MERGELOG = 6;
  private static final int MENU_SCREENMODE = 5;
  private static final int MENU_SCREENSHOT = 2;
  private static final int MENU_SENDLOG = 4;
  private static final int MENU_SWITCH = 1;
  ForegroundColorSpan ColorD = new ForegroundColorSpan(-16776961);
  ForegroundColorSpan ColorE = new ForegroundColorSpan(-65536);
  ForegroundColorSpan ColorI = new ForegroundColorSpan(-12483328);
  ForegroundColorSpan ColorV = new ForegroundColorSpan(-16777216);
  ForegroundColorSpan ColorW = new ForegroundColorSpan(-32945);
  private boolean Landscape_Mode = false;
  private c mAdapter;
  private int mCurrType = 0;
  private PullToRefreshListView mListView;
  private List<d> mLogs;
  
  /* Error */
  private void addData(BufferedReader paramBufferedReader)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 94	com/tencent/token/ui/ShowLogActivity:mLogs	Ljava/util/List;
    //   9: aload_0
    //   10: getfield 62	com/tencent/token/ui/ShowLogActivity:mCurrType	I
    //   13: invokeinterface 110 2 0
    //   18: checkcast 23	com/tencent/token/ui/ShowLogActivity$d
    //   21: getfield 113	com/tencent/token/ui/ShowLogActivity$d:a	Lcom/tencent/token/ui/ShowLogActivity$a;
    //   24: astore 5
    //   26: new 115	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 116	java/util/ArrayList:<init>	()V
    //   33: astore 4
    //   35: aload_1
    //   36: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +24 -> 65
    //   44: aload 4
    //   46: aload_0
    //   47: aload_3
    //   48: invokespecial 126	com/tencent/token/ui/ShowLogActivity:highlightLog	(Ljava/lang/String;)Landroid/text/SpannableString;
    //   51: invokeinterface 130 2 0
    //   56: pop
    //   57: aload_1
    //   58: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: astore_3
    //   62: goto -22 -> 40
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 133	com/tencent/token/ui/ShowLogActivity$a:a	(Ljava/util/List;)V
    //   72: aload_0
    //   73: aload 5
    //   75: invokespecial 100	com/tencent/token/ui/ShowLogActivity:updateData	(Lcom/tencent/token/ui/ShowLogActivity$a;)V
    //   78: aload_0
    //   79: getfield 135	com/tencent/token/ui/ShowLogActivity:mListView	Lcom/tencent/token/ui/base/PullToRefreshListView;
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 139 1 0
    //   90: iconst_3
    //   91: isub
    //   92: ifle +57 -> 149
    //   95: aload 4
    //   97: invokeinterface 139 1 0
    //   102: iconst_3
    //   103: isub
    //   104: istore_2
    //   105: goto +3 -> 108
    //   108: aload_3
    //   109: iload_2
    //   110: invokevirtual 144	com/tencent/token/ui/base/PullToRefreshListView:setSelection	(I)V
    //   113: aload_1
    //   114: invokevirtual 147	java/io/BufferedReader:close	()V
    //   117: return
    //   118: astore_3
    //   119: goto +16 -> 135
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   127: invokestatic 155	com/tencent/token/xj:c	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 147	java/io/BufferedReader:close	()V
    //   134: return
    //   135: aload_1
    //   136: invokevirtual 147	java/io/BufferedReader:close	()V
    //   139: aload_3
    //   140: athrow
    //   141: astore_1
    //   142: return
    //   143: astore_1
    //   144: return
    //   145: astore_1
    //   146: goto -7 -> 139
    //   149: iconst_0
    //   150: istore_2
    //   151: goto -43 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	ShowLogActivity
    //   0	154	1	paramBufferedReader	BufferedReader
    //   104	47	2	i	int
    //   39	70	3	localObject1	Object
    //   118	1	3	localObject2	Object
    //   122	18	3	localIOException	java.io.IOException
    //   33	63	4	localArrayList	ArrayList
    //   24	50	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   26	40	118	finally
    //   44	62	118	finally
    //   65	105	118	finally
    //   108	113	118	finally
    //   123	130	118	finally
    //   26	40	122	java/io/IOException
    //   44	62	122	java/io/IOException
    //   65	105	122	java/io/IOException
    //   108	113	122	java/io/IOException
    //   113	117	141	java/io/IOException
    //   130	134	143	java/io/IOException
    //   135	139	145	java/io/IOException
  }
  
  private void clearLog()
  {
    new b((byte)0).execute(new Void[0]);
  }
  
  private SpannableString highlightLog(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return localSpannableString;
    }
    String str = paramString.substring(0, 1);
    if (str.equals("V"))
    {
      localSpannableString.setSpan(this.ColorV, 0, paramString.length(), 33);
      return localSpannableString;
    }
    if (str.equals("D"))
    {
      localSpannableString.setSpan(this.ColorD, 0, paramString.length(), 33);
      return localSpannableString;
    }
    if (str.equals("I"))
    {
      localSpannableString.setSpan(this.ColorI, 0, paramString.length(), 33);
      return localSpannableString;
    }
    if (str.equals("W"))
    {
      localSpannableString.setSpan(this.ColorW, 0, paramString.length(), 33);
      return localSpannableString;
    }
    if (str.equals("E")) {
      localSpannableString.setSpan(this.ColorE, 0, paramString.length(), 33);
    }
    return localSpannableString;
  }
  
  private void initData()
  {
    this.mAdapter = new c((byte)0);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setRefreshTime(System.currentTimeMillis());
    this.mListView.setOnRefreshListener(new PullToRefreshListView.a()
    {
      public final void onRefresh()
      {
        ShowLogActivity.this.loadMoreLogs();
      }
    });
  }
  
  private void initLog()
  {
    if (this.mLogs == null)
    {
      this.mLogs = new ArrayList();
      d locald = new d();
      locald.a = new a();
      locald.b = -1;
      this.mLogs.add(locald);
    }
  }
  
  private void initUI()
  {
    setContentView(2131296443);
    this.mListView = ((PullToRefreshListView)findViewById(2131165689));
    View localView = LayoutInflater.from(this).inflate(2131296380, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    localView = LayoutInflater.from(this).inflate(2131296377, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    localView = LayoutInflater.from(this).inflate(2131296376, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    this.mListView.setScrollingCacheEnabled(true);
    this.mListView.a(2131493314);
  }
  
  private void loadMoreLogs()
  {
    int i = this.mCurrType;
    if (i >= 0)
    {
      Object localObject = this.mLogs;
      if (localObject != null)
      {
        if (i >= ((List)localObject).size()) {
          return;
        }
        localObject = (d)this.mLogs.get(this.mCurrType);
        if (((d)localObject).b + 1 >= 2) {
          return;
        }
        BufferedReader localBufferedReader = abu.b(((d)localObject).b + 1);
        if (localBufferedReader != null)
        {
          addData(localBufferedReader);
          ((d)localObject).b += 1;
        }
        return;
      }
    }
  }
  
  private void showlog(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.mLogs;
      if (localObject == null) {
        return;
      }
      this.mCurrType = paramInt;
      localObject = ((d)((List)localObject).get(this.mCurrType)).a;
      updateData((a)localObject);
      this.mListView.setSelection(this.mAdapter.getCount() - 1);
      if (((a)localObject).a.size() <= 0) {
        loadMoreLogs();
      }
      return;
    }
  }
  
  private void updateData(a parama)
  {
    c localc = this.mAdapter;
    localc.a.clear();
    if (parama != null) {
      parama.a(localc.a);
    }
    localc.notifyDataSetChanged();
    this.mListView.b(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initUI();
    initData();
    initLog();
    showlog(0);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  static final class a
  {
    final List<CharSequence> a = new LinkedList();
    private final boolean b = true;
    
    public final Collection<CharSequence> a(Collection<CharSequence> paramCollection)
    {
      Object localObject = paramCollection;
      if (paramCollection == null) {}
      try
      {
        localObject = new ArrayList();
        ((Collection)localObject).clear();
        ((Collection)localObject).addAll(this.a);
        return localObject;
      }
      finally {}
    }
    
    public final void a()
    {
      try
      {
        this.a.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void a(List<CharSequence> paramList)
    {
      try
      {
        int i = paramList.size();
        if (i == 0) {
          return;
        }
        if (this.b) {
          i = 0;
        } else {
          i = this.a.size();
        }
        this.a.addAll(i, paramList);
        return;
      }
      finally {}
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private b() {}
    
    protected final void onPreExecute()
    {
      ShowLogActivity localShowLogActivity = ShowLogActivity.this;
      localShowLogActivity.showProDialog(localShowLogActivity, 2131493568, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          ShowLogActivity.this.dismissDialog();
        }
      });
    }
  }
  
  final class c
    extends BaseAdapter
  {
    List<CharSequence> a = new ArrayList();
    
    private c() {}
    
    private CharSequence a(int paramInt)
    {
      return (CharSequence)this.a.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = ShowLogActivity.this.getLayoutInflater().inflate(2131296444, null);
        paramViewGroup = new a((byte)0);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131165690));
        paramView.setTag(paramViewGroup);
      }
      else
      {
        paramViewGroup = (a)paramView.getTag();
      }
      CharSequence localCharSequence = a(paramInt);
      paramViewGroup = paramViewGroup.a;
      paramViewGroup.setText(localCharSequence);
      paramViewGroup.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          return true;
        }
      });
      return paramView;
    }
    
    final class a
    {
      TextView a;
      
      private a() {}
    }
  }
  
  public final class d
  {
    public ShowLogActivity.a a;
    public int b;
    
    public d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ShowLogActivity
 * JD-Core Version:    0.7.0.1
 */