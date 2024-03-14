package LowLevelDesign.LLDBookMyShow;

import java.util.List;

public class Booking {
    String bookingId;
    Show show;
    Payment payment;
    List<Seat> bookedSeatIds;
    double amount;
    String bookingDate;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Seat> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Seat> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
