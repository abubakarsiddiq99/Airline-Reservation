    import org.apache.pdfbox.pdmodel.PDDocument;
    import org.apache.pdfbox.pdmodel.PDPage;
    import org.apache.pdfbox.pdmodel.PDPageContentStream;
    import org.apache.pdfbox.pdmodel.font.PDType1Font;

    import java.io.IOException;

    public class PDFGenerator {

        public static void generateBookingPDF(Ticket ticket) {
            PDDocument document = new PDDocument();

            try {
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(100, 750);  // Start position of text

                // Writing Ticket details to the PDF
                contentStream.showText("Flight Booking Details");
                contentStream.newLine();
                contentStream.showText("Ticket ID: " + ticket.getTicketId());
                contentStream.newLine();
                contentStream.showText("Passenger Name: " + ticket.getUser().getName());
                contentStream.newLine();
                contentStream.showText("Email: " + ticket.getUser().getEmail());
                contentStream.newLine();
                contentStream.showText("Flight: " + ticket.getFlight().getFlightId());
                contentStream.newLine();
                contentStream.showText("From: " + ticket.getFlight().getOrigin() + " To: " + ticket.getFlight().getDestination());
                contentStream.newLine();
                contentStream.showText("Seat: " + ticket.getSeat());
                contentStream.newLine();
                contentStream.showText("Booking Date: " + ticket.getBookingDate());
                contentStream.endText();

                contentStream.close();

                // Save the PDF document
                document.save("FlightBooking_" + ticket.getTicketId() + ".pdf");
                System.out.println("PDF generated successfully!");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
