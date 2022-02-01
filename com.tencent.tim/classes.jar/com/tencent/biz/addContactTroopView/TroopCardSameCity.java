package com.tencent.biz.addContactTroopView;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import java.util.List;
import jod;
import tencent.im.troop_search_searchtab.searchtab.Item2;

public class TroopCardSameCity
  extends BaseTroopCardView
{
  public List<searchtab.Item2> fI;
  protected BaseAdapter mAdapter = new jod(this);
  
  public TroopCardSameCity(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  public static class a
  {
    public ImageView hj;
    public TextView nl;
    public TextView nm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardSameCity
 * JD-Core Version:    0.7.0.1
 */