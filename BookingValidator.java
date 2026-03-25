public class BookingValidator {
    private RoomInventory inventory;

    public BookingValidator(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void validateBooking(Reservation reservation) throws InvalidBookingException {
        if (reservation.getGuestName() == null || reservation.getGuestName().trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }
        
        String roomType = reservation.getRoomType();
        if (!roomType.equals("Single Room") && !roomType.equals("Double Room") && !roomType.equals("Suite Room")) {
            throw new InvalidBookingException("Invalid room type selected: " + roomType);
        }
        
        int availableCount = inventory.getAvailableCount(roomType);
        if (availableCount <= 0) {
            throw new InvalidBookingException("Room type '" + roomType + "' is fully booked or unavailable.");
        }
    }
}
