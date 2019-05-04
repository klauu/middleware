//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.2
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public class LoanRequest implements java.lang.Cloneable,
                                    java.io.Serializable
{
    public String id;

    public Currency cur;

    public double amount;

    public int time;

    public LoanRequest()
    {
        this.id = "";
        this.cur = Currency.PLN;
    }

    public LoanRequest(String id, Currency cur, double amount, int time)
    {
        this.id = id;
        this.cur = cur;
        this.amount = amount;
        this.time = time;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        LoanRequest r = null;
        if(rhs instanceof LoanRequest)
        {
            r = (LoanRequest)rhs;
        }

        if(r != null)
        {
            if(this.id != r.id)
            {
                if(this.id == null || r.id == null || !this.id.equals(r.id))
                {
                    return false;
                }
            }
            if(this.cur != r.cur)
            {
                if(this.cur == null || r.cur == null || !this.cur.equals(r.cur))
                {
                    return false;
                }
            }
            if(this.amount != r.amount)
            {
                return false;
            }
            if(this.time != r.time)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Bank::LoanRequest");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, id);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, cur);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, amount);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, time);
        return h_;
    }

    public LoanRequest clone()
    {
        LoanRequest c = null;
        try
        {
            c = (LoanRequest)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.id);
        Currency.ice_write(ostr, this.cur);
        ostr.writeDouble(this.amount);
        ostr.writeInt(this.time);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.id = istr.readString();
        this.cur = Currency.ice_read(istr);
        this.amount = istr.readDouble();
        this.time = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, LoanRequest v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public LoanRequest ice_read(com.zeroc.Ice.InputStream istr)
    {
        LoanRequest v = new LoanRequest();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<LoanRequest> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, LoanRequest v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<LoanRequest> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(LoanRequest.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final LoanRequest _nullMarshalValue = new LoanRequest();

    /** @hidden */
    public static final long serialVersionUID = -1298212096L;
}
