package seedu.address.logic.commands;

import java.io.File;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.PhotoChangeEvent;
import seedu.address.logic.commands.exceptions.CommandException;

//@@author JasmineSee

/**
 * Delete all photos from all persons.
 */
public class DeleteAllPhotosCommand extends Command {
    public static final String COMMAND_WORD = "dallphotos";
    public static final String COMMAND_ALIAS = "dpall";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes all photos from all persons. "
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_DELETE_ALL_IMAGE_SUCCESS = "Deleted all photos";

    @Override
    public CommandResult execute() throws CommandException {
        deleteAllPhotos();
        EventsCenter.getInstance().post(new PhotoChangeEvent());

        LoggingCommand loggingCommand = new LoggingCommand();
        loggingCommand.keepLog("", "Deleted all photos");

        return new CommandResult(String.format(MESSAGE_DELETE_ALL_IMAGE_SUCCESS));
    }
    /**
     * Deletes all photos of persons in the address book.
     */
    public void deleteAllPhotos() {
        File dir = new File("photos/");
        for (File file : dir.listFiles()) {
            if (!(file.getName().equals("default.jpeg"))) {
                file.delete();
            }
        }
    }
}