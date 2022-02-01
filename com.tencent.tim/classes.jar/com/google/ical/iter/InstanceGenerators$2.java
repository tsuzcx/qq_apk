package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.Frequency;
import com.google.ical.values.Weekday;
import java.util.ArrayList;
import java.util.List;

final class InstanceGenerators$2
  extends Generator
{
  List<DateValue> candidates;
  boolean done = false;
  boolean first = true;
  int i;
  DateValue pushback = null;
  
  InstanceGenerators$2(Frequency paramFrequency, Generator paramGenerator1, Generator paramGenerator2, Weekday paramWeekday, Generator paramGenerator3, boolean paramBoolean, int paramInt, int[] paramArrayOfInt) {}
  
  public boolean generate(DTBuilder paramDTBuilder)
    throws Generator.IteratorShortCircuitingException
  {
    while ((this.candidates == null) || (this.i >= this.candidates.size()))
    {
      label30:
      label83:
      ArrayList localArrayList;
      int k;
      label119:
      DateValue localDateValue;
      if (this.done)
      {
        break label278;
        return false;
      }
      else if (this.pushback != null)
      {
        localObject = this.pushback;
        paramDTBuilder.year = ((DateValue)localObject).year();
        paramDTBuilder.month = ((DateValue)localObject).month();
        paramDTBuilder.day = ((DateValue)localObject).day();
        this.pushback = null;
        localArrayList = new ArrayList();
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        if (!this.val$allPositive) {
          break label315;
        }
        k = this.val$maxPos;
        if (k <= localArrayList.size()) {
          break label511;
        }
        if (!this.val$serialInstanceGenerator.generate(paramDTBuilder)) {
          this.done = true;
        }
        localDateValue = paramDTBuilder.toDate();
        if (localObject != null) {
          break label321;
        }
        j = 1;
        localObject = localDateValue;
      }
      for (;;)
      {
        if (j == 0) {
          break label505;
        }
        localArrayList.add(localDateValue);
        break label119;
        if (!this.first) {
          switch (InstanceGenerators.3.$SwitchMap$com$google$ical$values$Frequency[this.val$freq.ordinal()])
          {
          }
        }
        for (;;)
        {
          localObject = null;
          break label83;
          if (!this.val$yearGenerator.generate(paramDTBuilder)) {
            break label30;
          }
          do
          {
            if (this.val$monthGenerator.generate(paramDTBuilder)) {
              break;
            }
          } while (this.val$yearGenerator.generate(paramDTBuilder));
          return false;
          localObject = Util.nextWeekStart(paramDTBuilder.toDate(), this.val$wkst);
          label278:
          if (!this.val$serialInstanceGenerator.generate(paramDTBuilder)) {
            break label30;
          }
          if (paramDTBuilder.compareTo((DateValue)localObject) < 0) {
            break;
          }
          localObject = paramDTBuilder.toDate();
          break label83;
          this.first = false;
        }
        label315:
        k = 2147483647;
        break label119;
        label321:
        switch (InstanceGenerators.3.$SwitchMap$com$google$ical$values$Frequency[this.val$freq.ordinal()])
        {
        default: 
          j = 0;
          break;
        case 3: 
          if ((TimeUtils.daysBetween(localDateValue, (DateValue)localObject) < 7) && ((Weekday.valueOf(localDateValue).javaDayNum + 7 - this.val$wkst.javaDayNum) % 7 > (Weekday.valueOf((DateValue)localObject).javaDayNum + 7 - this.val$wkst.javaDayNum) % 7)) {
            j = 1;
          } else {
            j = 0;
          }
          break;
        case 2: 
          if ((((DateValue)localObject).month() == localDateValue.month()) && (((DateValue)localObject).year() == localDateValue.year())) {
            j = 1;
          } else {
            j = 0;
          }
          break;
        case 1: 
          if (((DateValue)localObject).year() == localDateValue.year()) {
            j = 1;
          } else {
            j = 0;
          }
          break;
        }
      }
      label505:
      this.pushback = localDateValue;
      label511:
      if (this.val$allPositive) {}
      for (localObject = this.val$uSetPos;; localObject = ((IntSet)localObject).toIntArray())
      {
        this.candidates = new ArrayList();
        j = 0;
        while (j < localObject.length)
        {
          k = localObject[j] - 1;
          if ((k >= 0) && (k < localArrayList.size())) {
            this.candidates.add(localArrayList.get(k));
          }
          j += 1;
        }
        localObject = new IntSet();
        j = 0;
        while (j < this.val$uSetPos.length)
        {
          int m = this.val$uSetPos[j];
          k = m;
          if (m < 0) {
            k = m + localArrayList.size() + 1;
          }
          ((IntSet)localObject).add(k);
          j += 1;
        }
      }
      this.i = 0;
      if (this.candidates.isEmpty()) {
        this.candidates = null;
      }
    }
    Object localObject = this.candidates;
    int j = this.i;
    this.i = (j + 1);
    localObject = (DateValue)((List)localObject).get(j);
    paramDTBuilder.year = ((DateValue)localObject).year();
    paramDTBuilder.month = ((DateValue)localObject).month();
    paramDTBuilder.day = ((DateValue)localObject).day();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.InstanceGenerators.2
 * JD-Core Version:    0.7.0.1
 */