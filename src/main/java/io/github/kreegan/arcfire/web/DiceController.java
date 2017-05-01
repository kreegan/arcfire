package io.github.kreegan.arcfire.web;

import io.github.kreegan.arcfire.dice.DiceRoller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller for dice functionality
 */
@RestController
@RequestMapping("/dice")
public class DiceController {

    @Resource
    DiceRoller diceRoller;

    @RequestMapping(path = "/roll", method = RequestMethod.GET)
    public String rollDiceIndividually(@RequestParam(name = "numSides") int numSides,
                                       @RequestParam(name = "numDiceToRoll") int numDiceToRoll) {
        return diceRoller.rollDiceIndividually(numSides, numDiceToRoll);
    }

    @RequestMapping(path = "/rollAndSum", method = RequestMethod.GET)
    public String rollDiceAndSum(@RequestParam(name = "numSides") int numSides,
                                 @RequestParam(name = "numDiceToRoll") int numDiceToRoll) {
        return String.valueOf(diceRoller.rollDiceAndSum(numSides, numDiceToRoll));
    }

    @RequestMapping(path = "/rollAndSumMod", method = RequestMethod.GET)
    public String rollDiceAndSumModified(@RequestParam(name = "numSides") int numSides,
                                         @RequestParam(name = "numDiceToRoll") int numDiceToRoll,
                                         @RequestParam("modifier") int modifier) {
        return String.valueOf(diceRoller.rollDiceAndSumModified(numSides, numDiceToRoll, modifier));
    }
}
