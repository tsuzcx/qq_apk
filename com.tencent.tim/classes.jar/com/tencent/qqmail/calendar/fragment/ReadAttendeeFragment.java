package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.calendar.data.Attendee;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.uitableview.UITableContainer;
import com.tencent.qqmail.utilities.uitableview.UITableItemBaseView;
import com.tencent.qqmail.utilities.uitableview.UITableItemTextView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ReadAttendeeFragment
  extends CalendarBaseFragment
{
  private ArrayList<String> acceptList;
  private ArrayList<String> declineList;
  private QMCalendarEvent event;
  private QMBaseView mBaseView;
  private ArrayList<String> noResponseList;
  private String organizer;
  private ArrayList<String> tentativeList;
  
  public ReadAttendeeFragment()
  {
    super(true);
  }
  
  private String getAttendeeDisplayName(Attendee paramAttendee)
  {
    if (StringUtils.isNotBlank(paramAttendee.getName())) {
      return paramAttendee.getName();
    }
    return paramAttendee.getEmail();
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = new QMTopBar(getActivity());
    this.mBaseView.addView(localQMTopBar);
    localQMTopBar.setTitle(getResources().getString(2131694727));
    localQMTopBar.setButtonLeftBack();
    localQMTopBar.setButtonLeftOnclickListener(new ReadAttendeeFragment.1(this));
  }
  
  public void initDataSource()
  {
    if (this.event != null)
    {
      this.organizer = this.event.getOrganizerName();
      this.acceptList = new ArrayList();
      this.tentativeList = new ArrayList();
      this.declineList = new ArrayList();
      this.noResponseList = new ArrayList();
      Object localObject = this.event.getAttendees();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Attendee localAttendee = (Attendee)((Iterator)localObject).next();
          switch (localAttendee.getStatus())
          {
          default: 
            this.noResponseList.add(getAttendeeDisplayName(localAttendee));
            break;
          case 3: 
            this.acceptList.add(getAttendeeDisplayName(localAttendee));
            break;
          case 2: 
            this.tentativeList.add(getAttendeeDisplayName(localAttendee));
            break;
          case 4: 
            this.declineList.add(getAttendeeDisplayName(localAttendee));
            break;
          case 5: 
            this.noResponseList.add(getAttendeeDisplayName(localAttendee));
          }
        }
      }
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    Object localObject3 = new UITableContainer(getActivity());
    ((UITableContainer)localObject3).setCaption(2131694723);
    Object localObject1 = new UITableContainer(getActivity());
    ((UITableContainer)localObject1).setCaption(2131694719);
    Object localObject2 = new UITableContainer(getActivity());
    ((UITableContainer)localObject2).setCaption(2131694720);
    paramBundle = new UITableContainer(getActivity());
    paramBundle.setCaption(2131694724);
    paramViewHolder = new UITableContainer(getActivity());
    paramViewHolder.setCaption(2131694721);
    paramView = new UITableContainer(getActivity());
    paramView.setCaption(2131694722);
    UITableItemTextView localUITableItemTextView;
    if (this.organizer != null)
    {
      localUITableItemTextView = new UITableItemTextView(getActivity());
      localUITableItemTextView.setTitle(this.organizer);
      ((UITableContainer)localObject3).addItem(localUITableItemTextView);
      this.mBaseView.addContentView((View)localObject3);
    }
    if (this.event.getAppointmentType() == 1)
    {
      if ((this.acceptList != null) && (this.acceptList.size() > 0))
      {
        localObject1 = this.acceptList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localUITableItemTextView = new UITableItemTextView(getActivity());
          localUITableItemTextView.setTitle((String)localObject3);
          ((UITableContainer)localObject2).addItem(localUITableItemTextView);
        }
        this.mBaseView.addContentView((View)localObject2);
      }
      if ((this.tentativeList != null) && (this.tentativeList.size() > 0))
      {
        localObject1 = this.tentativeList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject3 = new UITableItemTextView(getActivity());
          ((UITableItemTextView)localObject3).setTitle((String)localObject2);
          paramBundle.addItem((UITableItemBaseView)localObject3);
        }
        this.mBaseView.addContentView(paramBundle);
      }
      if ((this.declineList != null) && (this.declineList.size() > 0))
      {
        paramBundle = this.declineList.iterator();
        while (paramBundle.hasNext())
        {
          localObject1 = (String)paramBundle.next();
          localObject2 = new UITableItemTextView(getActivity());
          ((UITableItemTextView)localObject2).setTitle((String)localObject1);
          paramViewHolder.addItem((UITableItemBaseView)localObject2);
        }
        this.mBaseView.addContentView(paramViewHolder);
      }
      if ((this.noResponseList != null) && (this.noResponseList.size() > 0))
      {
        paramViewHolder = this.noResponseList.iterator();
        while (paramViewHolder.hasNext())
        {
          paramBundle = (String)paramViewHolder.next();
          localObject1 = new UITableItemTextView(getActivity());
          ((UITableItemTextView)localObject1).setTitle(paramBundle);
          paramView.addItem((UITableItemBaseView)localObject1);
        }
        this.mBaseView.addContentView(paramView);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.event == null);
      paramView = this.event.getAttendees();
    } while ((paramView == null) || (paramView.size() <= 0));
    paramView = paramView.iterator();
    while (paramView.hasNext())
    {
      paramViewHolder = (Attendee)paramView.next();
      paramBundle = new UITableItemTextView(getActivity());
      paramBundle.setTitle(getAttendeeDisplayName(paramViewHolder));
      ((UITableContainer)localObject1).addItem(paramBundle);
    }
    this.mBaseView.addContentView((View)localObject1);
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mBaseView.initScrollView();
    this.mBaseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.mBaseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void preEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    this.event = paramQMCalendarEvent;
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadAttendeeFragment
 * JD-Core Version:    0.7.0.1
 */