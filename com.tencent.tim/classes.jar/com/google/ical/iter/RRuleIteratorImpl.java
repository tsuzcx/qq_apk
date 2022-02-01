package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.Predicate;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;
import com.google.ical.values.TimeValue;
import java.util.TimeZone;

final class RRuleIteratorImpl
  implements RecurrenceIterator
{
  private static final DateValue MIN_DATE = new DateValueImpl(-2147483648, 1, 1);
  private DTBuilder builder_;
  private final boolean canShortcutAdvance_;
  private final Predicate<? super DateValue> condition_;
  private final Generator dayGenerator_;
  private boolean done_;
  private final DateValue dtStart_;
  private final Predicate<? super DateValue> filter_;
  private final Generator instanceGenerator_;
  private DateValue lastUtc_ = MIN_DATE;
  private final Generator monthGenerator_;
  private DateValue pendingUtc_;
  private final TimeZone tzid_;
  private final ThrottledGenerator yearGenerator_;
  
  RRuleIteratorImpl(DateValue paramDateValue, TimeZone paramTimeZone, Predicate<? super DateValue> paramPredicate1, Predicate<? super DateValue> paramPredicate2, Generator paramGenerator1, ThrottledGenerator paramThrottledGenerator, Generator paramGenerator2, Generator paramGenerator3, boolean paramBoolean, TimeValue paramTimeValue)
  {
    this.condition_ = paramPredicate1;
    this.filter_ = paramPredicate2;
    this.instanceGenerator_ = paramGenerator1;
    this.yearGenerator_ = paramThrottledGenerator;
    this.monthGenerator_ = paramGenerator2;
    this.dayGenerator_ = paramGenerator3;
    this.dtStart_ = paramDateValue;
    this.tzid_ = paramTimeZone;
    this.canShortcutAdvance_ = paramBoolean;
    this.builder_ = new DTBuilder(paramDateValue);
    if (paramTimeValue != null)
    {
      this.builder_.hour = paramTimeValue.hour();
      this.builder_.minute = paramTimeValue.minute();
      this.builder_.second = paramTimeValue.second();
    }
    try
    {
      this.yearGenerator_.generate(this.builder_);
      this.monthGenerator_.generate(this.builder_);
      if (!this.done_)
      {
        this.pendingUtc_ = generateInstance();
        if (this.pendingUtc_ == null) {
          this.done_ = true;
        }
      }
      else
      {
        return;
      }
    }
    catch (Generator.IteratorShortCircuitingException paramPredicate1)
    {
      do
      {
        do
        {
          for (;;)
          {
            this.done_ = true;
          }
        } while (this.pendingUtc_.compareTo(TimeUtils.toUtc(paramDateValue, paramTimeZone)) < 0);
      } while (this.condition_.apply(this.pendingUtc_));
      this.done_ = true;
      this.pendingUtc_ = null;
    }
  }
  
  private void fetchNext()
  {
    if ((this.pendingUtc_ != null) || (this.done_)) {
      return;
    }
    DateValue localDateValue = generateInstance();
    if ((localDateValue != null) && (this.condition_.apply(localDateValue)))
    {
      this.pendingUtc_ = localDateValue;
      this.yearGenerator_.workDone();
      return;
    }
    this.done_ = true;
  }
  
  private DateValue generateInstance()
  {
    try
    {
      if (!this.instanceGenerator_.generate(this.builder_)) {
        return null;
      }
      if ((this.dtStart_ instanceof TimeValue)) {}
      for (DateValue localDateValue = TimeUtils.toUtc(this.builder_.toDateTime(), this.tzid_); localDateValue.compareTo(this.lastUtc_) > 0; localDateValue = this.builder_.toDate()) {
        return localDateValue;
      }
      return null;
    }
    catch (Generator.IteratorShortCircuitingException localIteratorShortCircuitingException) {}
  }
  
  public void advanceTo(DateValue paramDateValue)
  {
    if ((this.pendingUtc_ != null) && (paramDateValue.compareTo(this.pendingUtc_) <= 0)) {}
    DateValue localDateValue;
    label217:
    do
    {
      return;
      for (;;)
      {
        localDateValue = TimeUtils.fromUtc(paramDateValue, this.tzid_);
        if (localDateValue.compareTo(this.builder_.toDate()) > 0)
        {
          this.pendingUtc_ = null;
          for (;;)
          {
            try
            {
              if (!this.canShortcutAdvance_) {
                break label217;
              }
              if (this.builder_.year >= localDateValue.year()) {
                break;
              }
              if (!this.yearGenerator_.generate(this.builder_))
              {
                this.done_ = true;
                return;
              }
            }
            catch (Generator.IteratorShortCircuitingException paramDateValue)
            {
              this.done_ = true;
              return;
            }
            if (this.builder_.year >= localDateValue.year()) {
              while (!this.monthGenerator_.generate(this.builder_)) {
                if (!this.yearGenerator_.generate(this.builder_)) {
                  this.done_ = true;
                }
              }
            }
          }
          do
          {
            return;
            while (this.monthGenerator_.generate(this.builder_)) {
              if ((this.builder_.year != localDateValue.year()) || (this.builder_.month >= localDateValue.month())) {
                break;
              }
            }
          } while (this.yearGenerator_.generate(this.builder_));
          this.done_ = true;
          return;
          while (!this.done_)
          {
            localDateValue = generateInstance();
            if (localDateValue == null)
            {
              this.done_ = true;
            }
            else
            {
              if (this.condition_.apply(localDateValue)) {
                break label262;
              }
              this.done_ = true;
            }
          }
        }
      }
    } while (localDateValue.compareTo(paramDateValue) < 0);
    label262:
    this.pendingUtc_ = localDateValue;
  }
  
  public boolean hasNext()
  {
    if (this.pendingUtc_ == null) {
      fetchNext();
    }
    return this.pendingUtc_ != null;
  }
  
  public DateValue next()
  {
    if (this.pendingUtc_ == null) {
      fetchNext();
    }
    DateValue localDateValue = this.pendingUtc_;
    this.pendingUtc_ = null;
    return localDateValue;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RRuleIteratorImpl
 * JD-Core Version:    0.7.0.1
 */