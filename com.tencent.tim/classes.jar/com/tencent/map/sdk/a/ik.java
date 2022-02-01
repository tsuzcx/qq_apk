package com.tencent.map.sdk.a;

import android.content.Context;
import android.widget.ListView;

public final class ik
  extends ListView
{
  private a a;
  
  public ik(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void handleDataChanged()
  {
    super.handleDataChanged();
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public final void setOnDataChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ik
 * JD-Core Version:    0.7.0.1
 */