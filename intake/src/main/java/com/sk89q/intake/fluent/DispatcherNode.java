/*
 * Intake, a command processing library
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) Intake team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.intake.fluent;

import com.sk89q.intake.CommandCallable;
import com.sk89q.intake.dispatcher.Dispatcher;
import com.sk89q.intake.dispatcher.SimpleDispatcher;
import com.sk89q.intake.parametric.ParametricBuilder;

/**
 * A collection of commands.
 */
public class DispatcherNode extends AbstractDispatcherNode {

    /**
     * Create a new instance.
     *
     * @param graph the root fluent graph object
     * @param parent the parent node, or null
     * @param dispatcher the dispatcher for this node
     */
    DispatcherNode(CommandGraph graph, AbstractDispatcherNode parent, SimpleDispatcher dispatcher) {
        super(graph, parent, dispatcher);
    }

    /**
     * {@inheritDoc}
     */
    public DispatcherNode registerMethods(Object object) {
        return (DispatcherNode) super.registerMethods(object);
    }

    /**
     * Create a new command that will contain sub-commands.
     *
     * <p>The object returned by this method can be used to add sub-commands. To
     * return to this "parent" context, use {@link DispatcherNode#graph()}.</p>
     *
     * @param alias the list of aliases, where the first alias is the primary one
     * @return an object to place sub-commands
     */
    public DispatcherNode group(String... alias) {
        SimpleDispatcher command = new SimpleDispatcher();
        getDispatcher().registerCommand(command, alias);
        return new DispatcherNode(graph, this, command);
    }

    /**
     * {@inheritDoc}
     */
    public DispatcherNode parent() {
        return (DispatcherNode) super.parent();
    }

}
