package com.tencent.biz.addContactTroopView;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import java.util.List;
import joe;
import tencent.im.troop_search_searchtab.searchtab.Item3;

public class TroopCardXingquBuluo
  extends BaseTroopCardView
{
  public List<searchtab.Item3> fJ;
  protected BaseAdapter mAdapter = new joe(this);
  
  public TroopCardXingquBuluo(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  public static class a
  {
    public ImageView hj;
    public TextView nl;
    public TextView nn;
    public TextView no;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardXingquBuluo
 * JD-Core Version:    0.7.0.1
 */