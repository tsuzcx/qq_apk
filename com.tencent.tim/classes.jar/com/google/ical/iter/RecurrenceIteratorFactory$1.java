package com.google.ical.iter;

import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.IcalObject;
import com.google.ical.values.RDateList;
import com.google.ical.values.RRule;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

final class RecurrenceIteratorFactory$1
  implements RecurrenceIterable
{
  RecurrenceIteratorFactory$1(DateValue paramDateValue, TimeZone paramTimeZone, IcalObject[] paramArrayOfIcalObject, boolean paramBoolean) {}
  
  public RecurrenceIterator iterator()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(new RDateIteratorImpl(new DateValue[] { TimeUtils.toUtc(this.val$dtStart, this.val$tzid) }));
    IcalObject[] arrayOfIcalObject = this.val$contentLines;
    int j = arrayOfIcalObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        IcalObject localIcalObject = arrayOfIcalObject[i];
        try
        {
          String str = localIcalObject.getName();
          if ("rrule".equalsIgnoreCase(str)) {
            localArrayList1.add(RecurrenceIteratorFactory.createRecurrenceIterator((RRule)localIcalObject, this.val$dtStart, this.val$tzid));
          } else if ("rdate".equalsIgnoreCase(str)) {
            localArrayList1.add(RecurrenceIteratorFactory.createRecurrenceIterator((RDateList)localIcalObject));
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (this.val$strict)
          {
            throw localIllegalArgumentException;
            if ("exrule".equalsIgnoreCase(localIllegalArgumentException)) {
              localArrayList2.add(RecurrenceIteratorFactory.createRecurrenceIterator((RRule)localIcalObject, this.val$dtStart, this.val$tzid));
            } else if ("exdate".equalsIgnoreCase(localIllegalArgumentException)) {
              localArrayList2.add(RecurrenceIteratorFactory.createRecurrenceIterator((RDateList)localIcalObject));
            }
          }
          else
          {
            RecurrenceIteratorFactory.access$000().log(Level.SEVERE, "Dropping bad recurrence rule line: " + localIcalObject.toIcal(), localIllegalArgumentException);
          }
        }
      }
      else
      {
        return new CompoundIteratorImpl(localArrayList1, localArrayList2);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RecurrenceIteratorFactory.1
 * JD-Core Version:    0.7.0.1
 */